package com.coding.test.baekjun;

import java.util.Scanner;

public class BJ_2839 {

    static Integer dp[];
    static int arr[];
    static int max;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        max = 0;

        dp = new Integer[N + 1];

        dp[0] = 0;	// 디폴트값이 null이므로 0으로 초기화 해주어야한다.
        dp[1] = 0;	// 디폴트값이 null이므로 0으로 초기화 해주어야한다.
        dp[3] = 1;
        dp[5] = 1;



        System.out.println(find(N));
    }

    static int find(int N) {
        if(N < 0){
            return -1;
        }

        // 아직 탐색하지 않는 N번째 계단일 경우
        if(dp[N] == null) {
            dp[N] = Math.min(find(N-3), find(N-5));
        }

        return dp[N];
    }
}
