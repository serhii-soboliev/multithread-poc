package org.sbk.datarace.counters.naive;

public class NaiveCounter {
    private int counter = 0;

    public int incrementAndGet() {
        this.counter++;
        return this.counter;
    }

    public int get() {
        return this.counter;
    }
}
