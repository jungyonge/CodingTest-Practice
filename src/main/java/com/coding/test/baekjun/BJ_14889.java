package com.coding.test.baekjun;

import java.util.LinkedList;
import java.util.Scanner;

public class BJ_14889 {

    public static int[] arr;
    public static LinkedList<int[]> arrResult = new LinkedList<>();

    public static int N, M;
    public static int max, min ;
    public static int gap = 99999999;
    public static int[][] stat;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = N /2;
        stat = new int[N][N];

        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < N ; j ++){
                stat[i][j] = in.nextInt();

            }
        }

        arr = new int[M];

        dfs(1, 0);
        for(int i = 0 ; i < arrResult.size() / 2 ; i ++){
            int[] stark = arrResult.get(i);
            int[] link = arrResult.get(arrResult.size() - 1 - i);
            int starkStat = 0;
            int linkStat = 0;
            for(int team = 0 ; team < stark.length ; team ++){
                for(int team2 = 0 ; team2 < stark.length ; team2 ++){
                    if(team == team2){
                        continue;
                    }else {
                        starkStat = starkStat + stat[stark[team] -1 ][stark[team2] -1 ];
                        linkStat = linkStat + stat[link[team]-1][link[team2]-1];
                    }
                }
            }
            int tempGap = Math.abs(starkStat - linkStat);
            gap = Math.min(tempGap,gap);

        }

        System.out.println(gap);

    }

    public static void dfs(int at, int depth) {

        if (depth == M) {
            int[] temp = arr.clone();
            arrResult.add(temp);
            return;
        }

        for (int i = at; i <= N; i++) {

            arr[depth] = i;
            dfs(i + 1, depth + 1);

        }
    }
}
