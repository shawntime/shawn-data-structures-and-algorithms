package com.shawntime.algorithms.times;

/**
 * 时间复杂度计算：假设一个分号结尾为一次执行指令
 */
public class TimeComplexityTest {

    /**
     *
     * 执行次数：14
     * 时间复杂度：O(1)
     */
    public static void test1(int n) {
        // System.out.println : 1
        if (n > 10) {
            System.out.println("n > 10");
        } else if (n > 5) {
            System.out.println("n > 5");
        } else {
            System.out.println("n <= 5");
        }

        /**
         * i = 0 : 1
         * i < 4 : 4
         * i++ : 4
         * System.out.println : 4
         */
        for (int i = 0; i < 4; i++) {
            System.out.println("test");
        }
    }

    /**
     * 执行次数：3n + 1
     * 时间复杂度：O(n)
     */
    public static void test2(int n) {
        /**
         * i = 0 : 1
         * i < n : n
         * i++ : n
         * System.out.println : n
         */
        for (int i = 0; i < n; i++) {
            System.out.println("test");
        }
    }

    /**
     * 执行次数： 2n + 1 + 3n^2 + n = 3n^2 + 3n + 1
     * 时间复杂度：O(n^2)
     */
    public static void test3(int n) {
        /**
         * i = 0 : 1
         * i < n : n
         * i++ : n
         * 2n + 1
         */
        for (int i = 0; i < n; i++) {
            /**
             * j = 0 : 1
             * j < n : n
             * j++ : n
             * System.out.println : n
             * n * (3n + 1) = 3n^2 + n
             */
            for (int j = 0; j < n; j++) {
                System.out.println("test");
            }
        }
    }

    /**
     * 执行次数：2n + 1 + 46n = 48n + 1
     * 时间复杂度：O(n)
     */
    public static void test4(int n) {
        // 1 + 2n + n * (1 + 45)
        // 1 + 2n + 46n
        // 48n + 1
        // O(n)

        /**
         * i = 0 : 1
         * i < n : n
         * i++ : n
         * 2n + 1
         */
        for (int i = 0; i < n; i++) {
            /**
             * j = 0 : 1
             * j < 15 : 15
             * j++ : 15
             * System.out.println : 15
             * n * (15 * 3 + 1) = 46n
             */
            for (int j = 0; j < 15; j++) {
                System.out.println("test");
            }
        }
    }

    /**
     * 执行次数 = log2(n)
     * 时间复杂度：O(logn)
     */
    public static void test5(int n) {
        // 8 = 2^3
        // 16 = 2^4

        // 3 = log2(8)
        // 4 = log2(16)
        while ((n = n / 2) > 0) {
            System.out.println("test");
        }
    }

    /**
     * 执行次数 : log5(n)
     * 时间复杂度：O(logn)
     */
    public static void test6(int n) {
        while ((n = n / 5) > 0) {
            System.out.println("test");
        }
    }

    /**
     * 执行次数： 1 + 2 * log(n) + log(n) * (3n + 1) = 1 + 3log(n) + 3nlog(n)
     * 时间复杂度：O(nlogn)
     */
    public static void test7(int n) {
        /**
         * i = 1 : 1
         * i < n : log(n)
         * i = i * 2 : log(n)
         * 1 + 2 * log(n)
         */
        for (int i = 1; i < n; i = i * 2) {
            /**
             * j = 0 : 1
             * j < n : n
             * j++ : n
             * System.out.println : n
             * log(n) * (3n + 1)
             */
            for (int j = 0; j < n; j++) {
                System.out.println("test");
            }
        }
    }

    /**
     * 执行次数：3n + 1
     * 时间复杂度： O(n)
     */
    public static void test8(int n) {
        int a = 10;
        int b = 20;
        int c = a + b;
        int[] array = new int[n];
        /**
         * i = 0 ：1
         * i < array.length : n
         * i++ : n
         * System.out.println : n
         * 3n + 1
         */
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + c);
        }
    }

    /**
     * 执行次数：3n + 1 + 3m + 1 = 3(m + n) + 2
     * O(m + n)
     */
    public static void test9(int n, int m) {
        /**
         * i = 0 : 1
         * i < n : n
         * ++i : n
         * System.out.println : n
         * 3n + 1
         */
        for (int i = 0; i < n; ++i) {
            System.out.println("i:" + i);
        }
        /**
         * i = 0 : 1
         * i < m : m
         * ++i : m
         * System.out.println : m
         * 3m + 1
         */
        for (int i = 0; i < m; ++i) {
            System.out.println("m:" + i);
        }
    }
}
