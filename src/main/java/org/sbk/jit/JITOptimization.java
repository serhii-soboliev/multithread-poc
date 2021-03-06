package org.sbk.jit;

public class JITOptimization {

    private static boolean enabled = true;

    private static int milliseconds = 5;

    public static void main(String[] args) {
        new Thread(JITOptimization::process).start();
        sleepMillSeconds(milliseconds);
        disableProcessing();
    }

    private static void disableProcessing() {
        enabled = false;
        System.err.println("Processing disable called");
    }

    private static boolean isEnabled() {
        return enabled;
    }

    private static void process()  {
        boolean printed = false;
        while (isEnabled()) {
            if(!printed) {
                System.err.println("Processing started");
                printed = true;
            }
        }
        System.err.println("Processing finished");
    }

    private static void sleepMillSeconds(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
