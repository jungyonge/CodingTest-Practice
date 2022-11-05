package com.coding.test.baekjun;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ_15654 {


    public static int[] arr;
    public static boolean[] visit;
    public static int[] numArr;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        numArr = new int[N];
        for (int i = 0; i < N; i++) {
            numArr[i] = in.nextInt();
        }
        Arrays.sort(numArr);

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);

    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {

            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = numArr[i];
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}
