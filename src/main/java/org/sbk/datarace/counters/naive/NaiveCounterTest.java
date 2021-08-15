package org.sbk.datarace.counters.naive;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;
import org.openjdk.jcstress.infra.results.I_Result;

@JCStressTest
@State
@Outcome(id = "200, 200", expect = Expect.ACCEPTABLE, desc = "IncrementAndGet is atomic operation")
@Outcome(id = "200, 100", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Actor1 started after Actor2")
@Outcome(id = "100, 200", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Actor2 started after Actor1")
public class NaiveCounterTest {
    NaiveCounter counter = new NaiveCounter();
    private static final int ITERATION_NUMBER = 100;

    @Actor
    void actor1(II_Result result) {
       for(int i=0; i<ITERATION_NUMBER;i++) {
           counter.incrementAndGet();
       }
       result.r1 = counter.get();
    }

    @Actor
    void actor2(II_Result result) {
        for(int i=0; i<ITERATION_NUMBER;i++) {
            counter.incrementAndGet();
        }
        result.r2 = counter.get();
    }

}

