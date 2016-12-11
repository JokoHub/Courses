package com.joko.tests.ThreadsExamples;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Joko on 08.12.2016.
 */
public class MyMonitor implements Runnable {

    private ThreadPoolExecutor executor;
    private int seconds;
    private boolean isActive = true;

    public MyMonitor(ThreadPoolExecutor threadPoolExecutor, int seconds) {
        executor = threadPoolExecutor;
        this.seconds = seconds;
    }

    public void shutdown() {
        isActive = false;
    }


    @Override
    public void run() {
        while (isActive) {
            System.out.println(String.format("MyMonitor : %d/%d Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                    executor.getPoolSize(), executor.getCorePoolSize(), executor.getActiveCount(), executor.getCompletedTaskCount(),
                    executor.getTaskCount(), executor.isShutdown(), executor.isTerminated()));

            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}