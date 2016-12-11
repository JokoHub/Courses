package com.joko.IBA.Threads;

/**
 * Created by Joko on 08.12.2016.
 */
public class TestThreeThreads {
    public static void main(String[] args) {
        Runnable runnable = new PrintMe();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.setName("T1 - Larry");
        thread2.setName("T2 - Curly");
        thread3.setName("T3 - Moe");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
