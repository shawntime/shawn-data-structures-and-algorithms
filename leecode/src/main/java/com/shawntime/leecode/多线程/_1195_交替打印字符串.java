package com.shawntime.leecode.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
 */
public class _1195_交替打印字符串 {

    private int n;

    public _1195_交替打印字符串(int n) {
        this.n = n;
    }

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();

    private Condition condition2 = lock.newCondition();

    private Condition condition3 = lock.newCondition();

    private Condition condition4 = lock.newCondition();

    private volatile boolean endFlag = false;

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        while (!endFlag) {
            condition1.await();
            if (!endFlag) {
                printFizz.run();
                condition4.signal();
            }
        }
        lock.unlock();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        while (!endFlag) {
            condition2.await();
            if (!endFlag) {
                printBuzz.run();
                condition4.signal();
            }
        }
        lock.unlock();
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        while (!endFlag) {
            condition3.await();
            if (!endFlag) {
                printFizzBuzz.run();
                condition4.signal();
            }
        }
        lock.unlock();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                condition3.signal();
                condition4.await();
            } else if (i % 3 == 0) {
                condition1.signal();
                condition4.await();
            } else if (i % 5 == 0) {
                condition2.signal();
                condition4.await();
            } else {
                printNumber.accept(i);
            }
        }
        endFlag = true;
        condition1.signal();
        condition2.signal();
        condition3.signal();
        lock.unlock();
    }
}
