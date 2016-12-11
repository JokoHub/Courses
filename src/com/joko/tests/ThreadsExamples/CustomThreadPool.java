package com.joko.tests.ThreadsExamples;

import java.util.concurrent.*;

/**
 * Created by Joko on 08.12.2016.
 */
public class CustomThreadPool {
    //public static void main(String[] args) throws InterruptedException {
    public int amountOfTasks = 1000;

    public int getAmountOfTasks() {
        return amountOfTasks;
    }

    public void setAmountOfTasks(int amountOfTasks) {
        this.amountOfTasks = amountOfTasks;
    }
        MyRejectedExecutionHandler rejectedExecutionHandler = new MyRejectedExecutionHandler();

    ThreadFactory threadFactory = Executors.defaultThreadFactory();

    ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 100, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(1000), threadFactory, rejectedExecutionHandler);

    MyMonitor monitor = new MyMonitor(executor, 3);

    public void start(){
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        for (int i = 0; i < amountOfTasks; i++){
            executor.execute(new WorkingThread("" + i));
        }
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.shutdown();
    }

}
