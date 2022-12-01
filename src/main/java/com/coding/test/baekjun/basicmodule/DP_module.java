package com.coding.test.baekjun.basicmodule;

import java.util.Scanner;

public class DP_module {
    //DP
    static Integer dp[];
    static int arr[];
    static int max;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        max = 0;
        arr = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = in.nextInt();
        }
        dp = new Integer[N + 1];

        dp[0] = arr[0];	// 디폴트값이 null이므로 0으로 초기화 해주어야한다.
        dp[1] = arr[1];

        if(N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(N));
    }

    static int find(int N) {
        // 아직 탐색하지 않는 N번째 계단일 경우
        if(dp[N] == null) {
            dp[N] = Math.max(Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N], find(N - 1));
        }

        return dp[N];
    }
}
