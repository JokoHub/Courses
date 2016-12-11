package com.joko.tests.ThreadsExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Joko on 08.12.2016.
 */
public class ThreadPool  {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 100000; i++){
            Runnable worker = new WorkingThread("" + i);
            executorService.execute(worker);
        }
        executorService.shutdown();


        while (!executorService.isTerminated()){}
        System.out.println("all threads finished");
    }
}
