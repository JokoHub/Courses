package com.joko.IBA.GUIExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Joko on 06.12.2016.
 */
public class ChatClient {

    private JTextArea output;
    private JTextField input;
    private JButton sendButton, quitButton;
    private JComboBox usernames;
    private JDialog dialog;
    private JFrame frame;

    public JTextArea getOutput() {
        return output;
    }

    public void setOutput(JTextArea output) {
        this.output = output;
    }

    public JTextField getInput() {
        return input;
    }

    public void setInput(JTextField input) {
        this.input = input;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public void setSendButton(JButton sendButton) {
        this.sendButton = sendButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public void setQuitButton(JButton quitButton) {
        this.quitButton = quitButton;
    }

    public JComboBox getUsernames() {
        return usernames;
    }

    public void setUsernames(JComboBox usernames) {
        this.usernames = usernames;
    }

    public JDialog getDialog() {
        return dialog;
    }

    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JScrollPane getTextPane() {
        return textPane;
    }

    public void setTextPane(JScrollPane textPane) {
        this.textPane = textPane;
    }

    private JScrollPane textPane;

    public ChatClient() {
        output = new JTextArea(10, 50);
        input = new JTextField(50);
        sendButton = new JButton("Send");
        quitButton = new JButton("Quit");
        usernames = new JComboBox();
        usernames.addItem("jane Doe");
        usernames.addItem("1337dud3");
        usernames.addItem("Java Geek");
        textPane = new JScrollPane(output, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public void launchFrame() {
        frame = new JFrame("Chat room");

        sendButton.addActionListener(new SendHandler());
        input.addActionListener(new SendHandler());
        frame.addWindowListener(new CloseHandler());
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(quitMenuItem);
        mb.add(file);

        JMenu help = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(new AboutHandler());
        help.add(aboutMenuItem);
        mb.add(help);

        frame.setJMenuBar(mb);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.add(output, BorderLayout.WEST);
        frame.add(input, BorderLayout.SOUTH);

        JPanel pl = new JPanel();
        pl.setLayout(new GridLayout(3, 1));
        pl.add(sendButton);
        pl.add(quitButton);
        pl.add(usernames);
        frame.add(pl, BorderLayout.CENTER);

        frame.add(textPane, BorderLayout.WEST);

        frame.pack();
        frame.setVisible(true);
    }

    private class SendHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = input.getText();
            output.append(usernames.getSelectedItem() + ": " + text + "\n");
            output.setCaretPosition(output.getDocument().getLength()-1);
            input.setText("");
        }
    }

    private class CloseHandler extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    private class AboutHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (dialog == null){
                dialog = new AboutDialog(frame, "About", true);
            }
            dialog.setVisible(true);
        }
    }

    private class AboutDialog extends JDialog implements ActionListener{

        public AboutDialog(Frame parent, String title, boolean modal){
            super(parent, title, modal);
            add(new JLabel("The ChatClient is a neat tool that allows you to talk to other ChatClients via ChatServer"),
                    BorderLayout.NORTH);
            JButton b = new JButton("OK");
            add(b, BorderLayout.SOUTH);
            b.addActionListener(this);
            pack();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        ChatClient c = new ChatClient();
        c.launchFrame();
    }
}
