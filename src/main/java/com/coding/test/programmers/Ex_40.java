package com.coding.test.programmers;

import java.math.BigInteger;

public class Ex_40 {
    public static long solution(long w, long h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }
    static long GCD(long a, long b){ // 최대공약수
        if (a%b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }

    public static void main(String[] args) {
        int w = 4;
        int h = 4;

        solution(w,h);
    }
}
