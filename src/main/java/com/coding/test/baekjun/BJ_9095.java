package com.coding.test.baekjun;

import java.util.Scanner;

public class BJ_9095 {

    static Integer dp[];
    static int arr[];
    static int max;
    static int count ;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        for(int i = 0 ; i < N ; i++){
            count= 0;
            int target_number = in.nextInt();
            dfs(0,target_number);
            System.out.println(count);
        }

    }

    static void dfs(int N, int target) {
        // 아직 탐색하지 않는 N번째 계단일 경우

        if( N > target){
            return;
        }
        if (N == target) {
            count++;
            return;
        }else {
            for(int i = 1 ; i < 4; i++){
                dfs(N + i, target);
            }
        }





    }
}
