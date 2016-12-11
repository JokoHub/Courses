package com.joko.tests.ThreadsExamples;

/**
 * Created by Joko on 08.12.2016.
 */
public class WorkingThread implements Runnable {
    private String command;

    public WorkingThread(String s){
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand(){
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
