package com.coding.test.baekjun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_18352 {

    static int n ;
    static int line_count;
    static int start_node ;
    static ArrayList<Integer>[] list;
    static int[] k_arr;
    static int target_k;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        line_count = sc.nextInt();
        target_k = sc.nextInt();
        start_node = sc.nextInt();
        list = new ArrayList[n+1];
        k_arr = new int[n+1];
        check = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
            k_arr[i] = -1;
        }
        for (int j = 0; j <line_count ; j++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
        }

        bfs(start_node);

        boolean ch = false;
        for(int i = 1 ; i < n+1 ; i++){
            if(k_arr[i] + 1 == target_k){
                System.out.println(i);
                ch = true;
            }
        }
        if(!ch){
            System.out.println(-1);
        }

    }

    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while (!q.isEmpty()) {
            int v = q.poll();
            check[v] = true;
            for(int i = 0 ; i < list[v].size() ; i ++){
                int next=list[v].get(i);
                if(k_arr[next] == -1){
                    q.add(next);
                    k_arr[next] = k_arr[v] + 1;
                }

            }

        }
    }
}
