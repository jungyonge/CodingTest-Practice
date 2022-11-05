package com.coding.test.programmers.algorithm;


import java.util.LinkedList;
import java.util.Scanner;

//https://st-lab.tistory.com/114
// 1 2 3
//1 2
//1 3
//2 1
//2 3
//3 1
//3 2
public class Dfs_Number {

    public static int[] arr;
    public static LinkedList list = new LinkedList<>();
    public static boolean[] visit;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);

    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print( val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {

            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }

}