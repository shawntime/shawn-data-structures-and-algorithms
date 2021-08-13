package com.shawntime.leecode.多线程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 */
public class _1116_打印零与奇偶数 {

    private int n;

    public _1116_打印零与奇偶数(int n) {
        this.n = n;
    }

    private volatile boolean endFlag = false;

    private AtomicInteger value = new AtomicInteger(1);

    private Lock lock = new ReentrantLock();

    private Condition zeroCondition = lock.newCondition();

    private Condition evenCondition = lock.newCondition();

    private Condition oddCondition = lock.newCondition();

    private CountDownLatch countDownLatch = new CountDownLatch(2);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        countDownLatch.await();
        lock.lock();
        for (int i = 1; i <= n; ++i) {
            printNumber.accept(0);
            if ((i & 1) == 1) {
                oddCondition.signal();
            } else {
                evenCondition.signal();
            }

            zeroCondition.await();

        }
        endFlag = true;
        oddCondition.signal();
        evenCondition.signal();
        lock.unlock();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        countDownLatch.countDown();
        while (!endFlag) {
            evenCondition.await();
            if (!endFlag) {
                printNumber.accept(value.getAndIncrement());
            }
            zeroCondition.signal();

        }
        lock.unlock();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        countDownLatch.countDown();
        while (!endFlag) {
            oddCondition.await();
            if (!endFlag) {
                printNumber.accept(value.getAndIncrement());
            }
            zeroCondition.signal();
        }
        lock.unlock();
    }

    public static void main(String[] args) {

        _1116_打印零与奇偶数 zeroEvenOdd = new _1116_打印零与奇偶数(10);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero((x) -> {
                    System.out.println(x + " " + Thread.currentThread().getName());
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "1").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even((x) -> {
                    System.out.println(x + " " + Thread.currentThread().getName());
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "2").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd((x) -> {
                    System.out.println(x + " " + Thread.currentThread().getName());
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "3").start();


    }
}
