package org.sbk.datarace;

public class SafeTestRunnable implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        for(int i=0; i<1_000_000; i++) {
            synchronized (this) {
                this.count++;
            }
        }
        System.out.printf("Thread=%s, count=%s%n", Thread.currentThread().getName(), count);
    }
}
