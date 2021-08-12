package org.sbk.datarace;

public class SafeDataRace {
    public static void main(String[] args) {
        Runnable r = new SafeTestRunnable();
        Thread t1 = new Thread(r, "Safe Thread 1");
        Thread t2 = new Thread(r, "Safe Thread 2");
        t1.start();
        t2.start();
    }
}
