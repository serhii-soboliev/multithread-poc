package org.sbk.datarace;

public class DataRace {
    public static void main(String[] args) {
        Runnable runnable = new TestRunnable();
        Thread t1 = new Thread(runnable, "Thread 1");
        Thread t2 = new Thread(runnable, "Thread 2");
        t1.start();
        t2.start();
    }
}
