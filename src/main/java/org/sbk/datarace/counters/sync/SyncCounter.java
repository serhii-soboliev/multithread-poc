package org.sbk.datarace.counters.sync;

public class SyncCounter {
    private int counter = 0;

    public void incrementAndGet() {
        synchronized (this) {
            this.counter++;
        }
    }

    public int get() {
        synchronized (this) {
            return this.counter;
        }
    }
}
