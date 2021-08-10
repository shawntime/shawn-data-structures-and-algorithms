package com.shawntime.leecode;

import java.util.concurrent.CountDownLatch;

/**
 * https://leetcode-cn.com/problems/print-in-order/
 */
public class _1114_按序打印 {


    private CountDownLatch countDownLatch1 = new CountDownLatch(1);

    private CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            countDownLatch1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            countDownLatch2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
