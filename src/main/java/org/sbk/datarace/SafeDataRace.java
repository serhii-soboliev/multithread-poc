package org.sbk.datarace;

public class SafeDataRace {
    public static void main(String[] args) {
        Thread t1 = new Thread(new SafeTestRunnable(), "Safe Thread 1");
        Thread t2 = new Thread(new SafeTestRunnable(), "Safe Thread 2");
        t1.start();
        t2.start();
    }
}
