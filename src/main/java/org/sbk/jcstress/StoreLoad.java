package org.sbk.jcstress;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.II_Result;

@JCStressTest
@State
@Outcome(id = "1, 1", expect = Expect.ACCEPTABLE, desc = "Both actors have finished in the same time")
@Outcome(id = "0, 1", expect = Expect.ACCEPTABLE, desc = "First Actor has finished before second")
@Outcome(id = "1, 0", expect = Expect.ACCEPTABLE, desc = "Second Actor has finished before first")
@Outcome(id = "0, 0", expect = Expect.ACCEPTABLE_INTERESTING, desc = "Intel can reorder Stores with Load")
public class StoreLoad {
    private int x, y;

    @Actor
    public void actor1(II_Result r) {
        x = 1; //store
        r.r1 = y; //load
    }

    @Actor
    public void actor2(II_Result r) {
        y = 1; //store
        r.r2 = x; // load
    }
}















































