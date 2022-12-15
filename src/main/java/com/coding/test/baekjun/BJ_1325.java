package com.coding.test.baekjun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1325 {

    //양방향 간선
    //그래프 grahp
    //연결된 요소의 개수
    static int[][] graph;
    static int V;
    static int E;
    static boolean[] visited;
    static int result;
    static int[] result_array;
    static int MAX_COUNT = Integer.MIN_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        graph = new int[V + 1][V + 1];
        result_array = new int[V+1];
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
            visited = new boolean[V + 1];
            bfs(i);
            result_array[i] = result;
            MAX_COUNT = Math.max(result,MAX_COUNT);

        }
        StringBuilder sb = new StringBuilder();
        int j = 0 ;
        for(int i : result_array){
            if(i == MAX_COUNT){
                sb.append(j + " ");
            }
            j++;
        }

        System.out.println(sb.toString());
        sc.close();
        return;
    }


    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            for(int i = 1 ; i < graph[v].length - 1 ; i ++){
                if(graph[v][i] != 0 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    result++;
                }
            }

        }
    }
}
