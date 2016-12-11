package com.joko.tests.ThreadsExamples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Joko on 08.12.2016.
 */
public class ThreadGUI {
    JFrame frame;
    public JTextArea outputArea;
    public JProgressBar progressBar;
    CustomThreadPool customThreadPool;
    Timer timer;

    public ThreadGUI() {
        frame = new JFrame("Thread monitor GUI");
        initlefthalf();
        initrighthalf();
        customThreadPool = new CustomThreadPool();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ThreadGUI threadGUI = new ThreadGUI();
                threadGUI.launchFrame();
            }
        });
    }

    public void launchFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void initrighthalf() {
        JPanel rightHalf = new JPanel();
        rightHalf.setLayout(new GridLayout(2, 1));
        outputArea = new JTextArea(20, 75);
        JPanel rightTop = new JPanel();
        rightTop.setLayout(new BorderLayout());
        rightTop.add(outputArea, BorderLayout.WEST);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        rightTop.add(scrollPane, BorderLayout.EAST);
        progressBar = new JProgressBar();
        rightHalf.add(rightTop);
        rightHalf.add(progressBar);
        frame.add(rightHalf, BorderLayout.EAST);
    }

    private void initlefthalf() {
        JPanel leftHalf = new JPanel();
        leftHalf.setLayout(new GridLayout(2, 1));
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonListener());
        JButton stopButton = new JButton("Stop and Exit");
        stopButton.addActionListener(new StopButtonListener());

        leftHalf.add(startButton);
        leftHalf.add(stopButton);

        frame.add(leftHalf, BorderLayout.WEST);
    }
    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jb = (JButton) e.getSource();
            jb.setEnabled(false);
            progressBar.setMinimum(0);
            progressBar.setMaximum(customThreadPool.getAmountOfTasks());
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    progressBar.setValue((int) customThreadPool.executor.getCompletedTaskCount());
                    outputArea.append(String.format("MyMonitor : %d/%d Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                            customThreadPool.executor.getPoolSize(), customThreadPool.executor.getCorePoolSize(), customThreadPool.executor.getActiveCount(),
                            customThreadPool.executor.getCompletedTaskCount(), customThreadPool.executor.getTaskCount(), customThreadPool.executor.isShutdown(),
                            customThreadPool.executor.isTerminated()) + "\n");
                }
            });
            timer.start();

            new SwingWorker(){
                @Override
                protected Object doInBackground() throws Exception {
                    customThreadPool.start();
                    return null;
                }
                }.execute();

        }
    }


    private class StopButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            customThreadPool.executor.shutdown();
            customThreadPool.executor = null;
            System.exit(0);
        }
    }
}
