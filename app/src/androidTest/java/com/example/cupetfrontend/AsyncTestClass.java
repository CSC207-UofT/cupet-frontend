package com.example.cupetfrontend;

import org.junit.Before;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class AsyncTestClass {
    /**
     * A latch that awaits asynchronous code execution until the latch is released.
     * The latch can be release manually, or until some time has passed.
     */
    private CountDownLatch latch;

    /**
     * Before each test case, create a new count down latch.
     */
    @Before
    public void setUpLatch() {
        latch = new CountDownLatch(1);
    }

    /**
     * Pause synchronous code execution to await for an asynchronous task.
     * <p>
     * If asynchronous threads are interrupted (through exceptions or etc.),
     * fail the current test.
     * <p>
     * If the task is incomplete by the end of the timer,
     * fail the current test.
     *
     * @param ms The time to wait in ms.
     */
    public void awaitForTask(int ms) {
        try {
            boolean didCompleteInTime = latch.await(ms, TimeUnit.MILLISECONDS);

            if (!didCompleteInTime) {
                fail("Async task ran out of time");
            }
        } catch (InterruptedException e) {
            fail("Async thread was interrupted: " + e.getMessage());
        }
    }

    /**
     * Release any pauses to synchronous code execution and mark the task as
     * complete.
     */
    public void setTaskComplete() {
        latch.countDown();
    }
}
