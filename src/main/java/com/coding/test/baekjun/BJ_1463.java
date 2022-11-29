package com.coding.test.baekjun;

import java.util.Scanner;

public class BJ_1463 {

    static int[] arr;		// 배열
    static Integer[] dp;		// 메모이제이션 할 dp
    static int max;			// 최댓값 변수

    public static void main(String[] args) {
        int count = 0;
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        dp = new Integer[1000000];


        dp[0] = dp[1] = 0;

        System.out.print(recur(N));
        System.out.println(count);
    }

    static int recur(int N) {

        if (dp[N] == null) {
            // 6으로 나눠지는 경우
            if (N % 6 == 0) {
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (N % 2 == 0) {
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                dp[N] = recur(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
