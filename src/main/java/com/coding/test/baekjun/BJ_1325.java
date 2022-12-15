package com.coding.test.baekjun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ_1325 {

    //양방향 간선
    //그래프 grahp
    //연결된 요소의 개수
    static int[][] graph;
    static int V;
    static int E;
    static boolean[][] visited;
    static int result;
    static int MAX_COUNT = Integer.MIN_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        graph = new int[V + 1][V + 1];
        visited = new boolean[V + 1][V + 1];

        int a, b;
        for (int i = 0; i < E; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            // 간선 연결
            graph[b][a] = 1;
        }

        ArrayList<Integer> count = new ArrayList<>();
        // dfs 탐색
        for (int i = 1; i <= V; i++) {
            result = 0;
            dfs(i, visited[i]);

            if (result > MAX_COUNT) {
                MAX_COUNT = result;
                count.clear();
            }
            if (result >= MAX_COUNT) {
                count.add(i);
            }
        }
        Collections.sort(count);
        for (Integer i : count) {
            System.out.println(i);
        }

        sc.close();
        return;
    }

    public static void dfs(int index,boolean[] visited_index) {

        for (int i = 1; i <= V; i++) {

            if (graph[index][i] == 1 && !visited_index[i]) {
                visited_index[i] = true;

                dfs(i,visited_index);
                result++;
            }
        }

    }
}
