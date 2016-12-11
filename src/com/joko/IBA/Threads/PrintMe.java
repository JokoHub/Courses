package com.joko.IBA.Threads;

/**
 * Created by Joko on 08.12.2016.
 */
public class PrintMe implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName());
        }
        try{
            Thread.sleep(2000);
        } catch (Exception e){}
    }
}
