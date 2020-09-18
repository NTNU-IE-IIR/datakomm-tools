package no.ntnu.datakomm;

import java.util.Random;

/**
 * This example shows one option to run code in a new thread: create a class
 * that extends the Thread class.
 *
 * We simulate some long calculations to demonstrate parallel execution.
 */
public class OptionAThread extends Thread {
    Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        // Start three calculation threads in parallel
        Thread t1 = new OptionAThread();
        Thread t2 = new OptionAThread();
        Thread t3 = new OptionAThread();
        t1.start();
        t2.start();
        t3.start();
        for (int i = 0; i < 5; ++i) {
            System.out.println("The main thread is still running");
            Thread.sleep(1000); // Put the current thread to sleep for 1 second.
        }
        System.out.println("Main thread finished work");
    }

    @Override
    public void run() {
        long currentThreadId = Thread.currentThread().getId();
        for (int i = 0; i < 5; ++i) {
            System.out.println("Thread #" + currentThreadId + " calculating something...");
            // Sleep some random time
            int sleepTime = 1000 + random.nextInt(2000);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                System.out.println("Someone interrupted sleeping for thread"
                        + currentThreadId);
            }
        }
        System.out.println("Thread #" + currentThreadId + " finished work");
    }
}
