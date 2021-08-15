package org.sbk.datarace.reordering;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

@JCStressTest
@State
@Outcome(id = "1", expect = Expect.ACCEPTABLE, desc = "Actor2 is executed before Actor1")
@Outcome(id = "2", expect = Expect.ACCEPTABLE, desc = "Actor2 is executed after y = 2 and before x = 3 in Actor1")
@Outcome(id = "3", expect = Expect.FORBIDDEN, desc = "y = 2 can not be reordered with x = 3 as we have volatile on x")
@Outcome(id = "6", expect = Expect.ACCEPTABLE, desc = "Actor2 executed after Actor1")
public class ReorderingTestInValid {
    int y = 1;
    volatile int x = 1;

    @Actor
    void actor1() {
        y = 2;
        x = 3;
    }

    @Actor
    void actor2(I_Result r) {
        //in java, expressions are evaluated from left to right, so the last line:
        // r.r1 = y * x should be reversed: r.r1 = x * y to guarantee happens-before
        r.r1 =  y * x;
    }
}















































