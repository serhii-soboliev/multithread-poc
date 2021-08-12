package org.sbk.jit;

public class JITOptimization {

    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(JITOptimization::process).start();
        Thread.sleep(1000);
        new Thread(JITOptimization::terminate).start();
    }

    private static void terminate() {
        flag = false;
        System.out.println("Flag has been set to False");
    }

    private static boolean getFlag() {
        return flag;
    }

    private static void process() {
        boolean printed = false;
        while (getFlag()) {
            if(!printed) {
                System.out.println("I'm inside the loop!");
                printed = true;
            }
        }
        System.out.println("I'm outside the loop");
    }
}
