package com.coding.test.baekjun;

import java.util.Scanner;

public class BJ_11053 {

    //DP
    static Integer dp[];
    static int arr[];
    static int max;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        max = 0;
        arr = new int[N ];
        dp = new Integer[N ];

        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        for(int i = 0; i < N; i++) {
            find(i);
        }
        max = dp[0];
        for(int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    static int find(int N) {
        // 아직 탐색하지 않는 N번째 계단일 경우
        if(dp[N] == null) {
//            if(arr[N - 1] < arr[N] && arr[N - 2] < arr[N]){
//                dp[N] = Math.max(find(N - 1), find(N - 2)) + 1;
//            }else if(arr[N - 1] < arr[N]){
//                dp[N] = find(N - 1) + 1;
//            }else if(arr[N - 2] < arr[N]){
//                dp[N] = find(N - 2) + 1;
//            }else {
//                dp[N] = 1;
//            }
            dp[N] = 1;
            for(int i = N - 1 ; 0 <= i ; i--){
                if(arr[i ] < arr[N]){
                    dp[N] = Math.max(dp[N],find(i ) + 1);

                }
            }

        }

        return dp[N];
    }
}
