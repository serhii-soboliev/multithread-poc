package org.sbk.jit;

public class JITOptimization {

    private boolean enabled = true;

    public static void main(String[] args) throws InterruptedException {
        var jitOptimization = new JITOptimization();
        new Thread(jitOptimization::process).start();
        Thread.sleep(5);
        new Thread(jitOptimization::disableProcessing).start();
    }

    private void disableProcessing() {
        enabled = false;
        System.out.println("Processing disable called");
    }

    private boolean isEnabled() {
        return enabled;
    }

    private void process() {
        boolean printed = false;
        while (isEnabled()) {
            if(!printed) {
                System.out.println("Processing started");
                printed = true;
            }
        }
        System.out.println("Processing finished");
    }
}
