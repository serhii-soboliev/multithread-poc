package org.sbk.datarace;

public class NoDataRace {
    public static void main(String[] args) {
        Thread t1 = new Thread(new TestRunnable(), "Thread 1");
        Thread t2 = new Thread(new TestRunnable(), "Thread 2");
        t1.start();
        t2.start();
    }
}
