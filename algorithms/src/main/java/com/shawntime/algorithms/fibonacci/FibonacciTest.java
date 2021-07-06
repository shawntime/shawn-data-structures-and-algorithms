package com.shawntime.algorithms.fibonacci;

import java.util.Stack;

/**
 * 斐波那契数列实现
 * F(0)=0，F(1)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 2，n ∈ N*）
 *
 * 位置： 0 1 2 3 4 5 6 7
 * 数列： 0 1 1 2 3 5 8 13
 */
public class FibonacciTest {

    public static void main(String[] args) {
        int n = 40;
        System.out.println(fib1(n));
        System.out.println(fib2(n));
        System.out.println(fib3(n));
    }

    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; ++i) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    /**
     * 栈实现
     */
    public static int fib3(int n) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        stack.push(1);
        for (int i = 0; i < n - 1; ++i) {
            Integer second = stack.pop();
            Integer first = stack.pop();
            int sum = first + second;
            stack.push(second);
            stack.push(sum);
        }
        return stack.pop();
    }

}
