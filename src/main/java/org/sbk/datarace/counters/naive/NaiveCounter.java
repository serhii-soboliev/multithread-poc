package org.sbk.datarace.counters.naive;

public class NaiveCounter {
    private int counter = 0;

    public void incrementAndGet() {
        this.counter++;
    }

    public int get() {
        return this.counter;
    }
}
