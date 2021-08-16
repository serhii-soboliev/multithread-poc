package org.sbk.datarace.counters.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {
    private int counter = 0;
    private final Lock lock = new ReentrantLock();

    public void incrementAndGet() {
        try {
            lock.lock();
            this.counter++;
        } finally {
            lock.unlock();
        }
    }

    public int get() {
        try {
            lock.lock();
            return counter;
        } finally {
            lock.unlock();
        }
    }
}
