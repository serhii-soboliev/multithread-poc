package org.sbk.datarace.counters.sync;

public class SyncCounter {
    private int counter = 0;

    public int incrementAndGet() {
        synchronized (this) {
            this.counter++;
            return this.counter;
        }
    }

    public int get() {
        synchronized (this) {
            return this.counter;
        }
    }
}
