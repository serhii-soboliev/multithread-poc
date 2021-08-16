package org.sbk.datarace.counters.lock;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;
import org.sbk.datarace.counters.lock.LockCounter;

import java.util.concurrent.locks.Lock;

@JCStressTest
@State
@Outcome(id = "200", expect = Expect.ACCEPTABLE, desc = "IncrementAndGet is atomic operation")
public class LockCounterTest {
    LockCounter counter = new LockCounter();
    private static final int ITERATION_NUMBER = 100;

    @Actor
    void actor1() {
        for(int i=0; i<ITERATION_NUMBER;i++) {
            counter.incrementAndGet();
        }
    }

    @Actor
    void actor2() {
        for(int i=0; i<ITERATION_NUMBER;i++) {
            counter.incrementAndGet();
        }
    }

    @Arbiter
    void arbiter(I_Result result) {
        result.r1 = counter.get();
    }
}

