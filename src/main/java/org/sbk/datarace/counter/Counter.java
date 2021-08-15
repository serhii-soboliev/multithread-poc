package org.sbk.datarace.counter;

public class Counter {
    private int counter = 0;

    public int incrementAndGet() {
        this.counter++;
        return this.counter;
    }

    public int get() {
        return this.counter;
    }
}
