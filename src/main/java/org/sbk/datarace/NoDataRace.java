package org.sbk.datarace;

public class NoDataRace {
    public static void main(String[] args) {
        Thread t1 = new Thread(new TestRunnable());
        Thread t2 = new Thread(new TestRunnable());
        t1.start();
        t2.start();
    }
}
