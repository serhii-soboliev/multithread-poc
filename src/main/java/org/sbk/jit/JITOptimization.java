package org.sbk.jit;

public class JITOptimization {

    private static boolean enabled = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(JITOptimization::process).start();
        Thread.sleep(1000);
        new Thread(JITOptimization::disableProcessing).start();
    }

    private static void disableProcessing() {
        enabled = false;
        System.err.println("Processing disable called");
    }

    private static boolean isEnabled() {
        return enabled;
    }

    private static void process() {
        boolean printed = false;
        while (isEnabled()) {
            if(!printed) {
                System.err.println("Processing started");
                printed = true;
            }
        }
        System.err.println("Processing finished");
    }

    private static void process2() {
        boolean printed = isEnabled();
        while (printed) {
            if(!printed) {
                System.err.println("Processing started");
                printed = true;
            }
        }
        System.err.println("Processing finished");
    }
}
