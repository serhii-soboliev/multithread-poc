package org.sbk.datarace;

public class DataRace {
    public static void main(String[] args) {
        Runnable runnable = new TestRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
    }
}
