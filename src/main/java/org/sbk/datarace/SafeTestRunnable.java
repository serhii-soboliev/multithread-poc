package org.sbk.datarace;

public class SafeTestRunnable implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        for(int i=0; i<100000; i++) {
            synchronized (this) {
                count += 1;
            }
        }
        System.out.printf("Thread=%s, count=%s%n", Thread.currentThread().getName(), count);
    }
}
