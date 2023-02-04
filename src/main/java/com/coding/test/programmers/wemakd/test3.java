package com.coding.test.programmers.wemakd;

public class test3 {

    public static int sol(int[] n) {

        int gcd = getGCD(n[0], n[1]);
        for (int i = 2; i < n.length; i++) {
            gcd = getGCD(gcd, n[i]);
        }

        return gcd;
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }

    public static void main(String[] args) {

        System.out.println(sol(new int[]{10, 20, 30, 15}));
    }
}
