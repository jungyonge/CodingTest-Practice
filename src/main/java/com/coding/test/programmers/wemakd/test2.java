package com.coding.test.programmers.wemakd;

public class test2 {

    public static int solution(int n) {
        if (n < 10) {
            return n;
        }

        long num1 = 9;
        long num2 = 1;
        long sum = 9;

        while (n >= (num1 * 10) * (num2 + 1)) {
            num1 *= 10;
            num2 += 1;
            sum += num1 * num2;
        }

        n -= (sum + 1);
        String str = String.valueOf((int) Math.pow(10, num2) + n / (num2 + 1));
        return str.charAt(n % ((int) num2 + 1)) - '0';
    }

    public static void main(String[] args) {

        System.out.println(solution(99999999));
    }
}
