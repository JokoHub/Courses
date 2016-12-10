package com.joko.IBA.GUIAdvanced;

import com.joko.IBA.Exceptions.OverdraftException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class ATMClient {

    Customer customer;
    Account account;
    private JTextArea outputArea;
    private JTextField inputField, messageField;
    private JFrame frame;
    JButton[] actionButtons;
    private boolean isDeposit;


    private static final String USAGE
            = "USAGE: java com.joko.IBA.GUIAdvanced.ATMClient <dataFilePath>";

    public static void main(String[] args) {

        // Retrieve the dataFilePath command-line argument
        if (args.length != 1) {
            System.out.println(USAGE);
        } else {
            String dataFilePath = args[0];

            try {
                System.out.println("Reading data file: " + dataFilePath);
                // Create the data source and load the Bank data
                DataSource dataSource = new DataSource(dataFilePath);
                dataSource.loadData();

                // Run the ATM GUI
                ATMClient client = new ATMClient();
                client.launchFrame();

            } catch (IOException ioe) {
                System.out.println("Could not load the data file.");
                System.out.println(ioe.getMessage());
                ioe.printStackTrace(System.err);
            }
        }
    }

    public ATMClient() {
        frame = new JFrame("Java Bank ATM");
        initLeftHalf();
        initRightHalf();
    }

    public void launchFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void initLeftHalf(){
        JPanel leftHalf = new JPanel();
        leftHalf.setLayout(new GridLayout(2, 1));
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 1));
        actionButtons = new JButton[]{new JButton("Display account balance"),
                new JButton("Make a deposit"),
                new JButton("Make a wirthdrawal")};
        for (int i = 0; i < actionButtons.length; i++){
            buttonsPanel.add(actionButtons[i]);
            actionButtons[i].addActionListener(new ActionButtonsListener());
        }
        enableActionButtons(false);



        JPanel entryKeyPadPanel = new JPanel();
        entryKeyPadPanel.setLayout(new BorderLayout());
        inputField = new JTextField(10);
        entryKeyPadPanel.add(inputField, BorderLayout.NORTH);

        JPanel inputButtonsPanel = new JPanel();
        inputButtonsPanel.setLayout(new GridLayout(4,3));
        JButton[] numberButtons = new JButton[]{new JButton("1"),
                new JButton("2"),
                new JButton("3"),
                new JButton("4"),
                new JButton("5"),
                new JButton("6"),
                new JButton("7"),
                new JButton("8"),
                new JButton("9"),
                new JButton("0"),
                new JButton("."),
                new JButton("Enter")};

        for (int i = 0; i < numberButtons.length; i++){
            inputButtonsPanel.add(numberButtons[i]);
        }
        for (int i = 0; i < numberButtons.length-1; i++) {
            numberButtons[i].addActionListener(new InputListener());
        }
        numberButtons[numberButtons.length-1].addActionListener(new EnterButtonListener());

        entryKeyPadPanel.add(inputButtonsPanel, BorderLayout.SOUTH);

        leftHalf.add(buttonsPanel);
        leftHalf.add(entryKeyPadPanel);
        frame.add(leftHalf, BorderLayout.WEST);
    }

    public void initRightHalf(){
        JPanel rightHalf = new JPanel();
        rightHalf.setLayout(new BorderLayout());
        outputArea = new JTextArea(10, 75);
        outputArea.append("Enter your customer ID into the key pad and press Enter button" + "\n");
        rightHalf.add(outputArea, BorderLayout.CENTER);
        messageField = new JTextField(75);
        rightHalf.add(messageField, BorderLayout.SOUTH);
        frame.add(rightHalf, BorderLayout.EAST);

    }

    public void enableActionButtons(boolean enable){
        for (JButton button: actionButtons){
            button.setEnabled(enable);
        }
    }
    String text = "";
    private class InputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            inputField.setText(inputField.getText() + e.getActionCommand());
        }
    }

    private class ActionButtonsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            inputField.setText("");
            switch (e.getActionCommand()){
                case "Display account balance":
                {
                    outputArea.append(customer.getAccount(0).getBalance() + "\n");
                    break;
                }
                case "Make a deposit":
                {
                    outputArea.append("Input amount to deposit" + "\n");
                    isDeposit = true;
                    break;
                }
                case "Make a wirthdrawal":
                {
                    outputArea.append("Input amount to wirthdraw" + "\n");
                    isDeposit = false;
                    break;
                }
            }
        }
    }


    public Customer loadCustomer(int id){
        return Bank.getCustomer(id);
    }

    private class EnterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (customer == null){
                try {
                    customer = loadCustomer(Integer.parseInt(inputField.getText()));
                    outputArea.append("Welcome " + customer.getFirstName() + " " + customer.getLastName()+ "\n");
                    inputField.setText("");
                    enableActionButtons(true);
                }
                catch (Exception exc){
                    outputArea.append("Customer id was not found" + "\n");
                    inputField.setText("");
                    enableActionButtons(false);
                }

            }
            else{ if(isDeposit == true){
               Double amount = Double.parseDouble(inputField.getText());
                customer.getAccount(0).deposit(amount);
                outputArea.append("Deposit of " + amount + " was succesful! \n");
                inputField.setText("");
            } else {
                Double amount = Double.parseDouble(inputField.getText());
                try {
                    customer.getAccount(0).withdraw(amount);
                    inputField.setText("");
                    outputArea.append("Wirthdraw was succesfull! \n");
                } catch (OverdraftException e1) {
                    outputArea.append("Your wirthdraw of " + amount + " was not completed, not enough money.\n" );
                    inputField.setText("");
                } catch (Exception exc){
                    outputArea.append("Unknown error \n");
                    inputField.setText("");
                }
            }

            }
        }
    }
}
