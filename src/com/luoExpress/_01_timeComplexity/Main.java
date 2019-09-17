package com.luoExpress._01_timeComplexity;



/**
 fibonacci number
 * 0 1 2 3 4 5
 * 0 1 1 2 3 5 8 13 ....
 */

// O(2^n)

public class Main {


    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib1(n - 1) + fib1(n - 2);
        }
    }

    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        } else {
            int first = 0;
            int second = 1;
            for (int i = 0; i < n - 1; i++) {//一共n个数字，所以需要加n-1次
                int sum = first + second;
                first = second;
                second = sum;
            }
            return second;
        }
    }

    public static void main(String[] args) {
        System.out.println(fib1(5));
        System.out.println(fib2(64));

    }
}