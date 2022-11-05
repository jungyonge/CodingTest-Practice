package com.coding.test.programmers.algorithm;

import java.util.Scanner;

public class Dfs_Number2 {
// 1 2 3
//    1 2
//    1 3
//    2 3
    public static int[] arr;
    public static int N, M;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        arr = new int[M];

        dfs(1, 0);

    }

    public static void dfs(int at, int depth) {

        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= N; i++) {

            arr[depth] = i;
            dfs(i + 1, depth + 1);

        }
    }
}


//public class boj_15650 {
//    static StringBuilder sb = new StringBuilder();
//    static int n, m;
//    static boolean[] visit;
//    static int[] arr;
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        visit = new boolean[n];
//        arr = new int[m];
//        dfs(0,0);
//        System.out.println(sb);
//    }
//
//    private static void dfs(int depth, int start) {
//        if (depth == m) {
//            for (int val : arr) {
//                sb.append(val).append(" ");
//            }
//            sb.append("\n");
//            return;
//        }
//
//        for (int i = start; i < n; i++) {
//            if (!visit[i]) {
//                visit[i] = true;
//                arr[depth] = i + 1;
//                dfs(depth + 1, i+1);
//                visit[i] = false;
//            }
//        }
//    }
//}