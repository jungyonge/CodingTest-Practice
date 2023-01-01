package com.coding.test.supercat;

import java.util.ArrayList;

public class test2 {

    static int n;
    static ArrayList<Integer>[] list;
    static int[] friends;
    static boolean[] check;


    public static int[] solution(int N, int[][] relation) {
        n = N;

        list = new ArrayList[n];
        friends = new int[n];
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int j = 0; j < relation.length ; j++) {
            int a = relation[j][0] - 1;
            int b = relation[j][1] - 1;

            list[a].add(b);
            list[b].add(a);
        }

        for (int now_node = 0; now_node < n; now_node++) {
            int count = 0;
            check[now_node] = true;
            for (int child_node : list[now_node]) {
                if(!check[child_node]){
                    count++;
                    check[child_node] = true;
                }
                for (int grand_child_node : list[child_node]) {
                    if (!check[grand_child_node]) {
                        check[grand_child_node] = true;
                        count++;
                    }
                }
            }
            friends[now_node] = count;
            check = new boolean[n];
        }

        return friends;

    }

    private static void dfs(int v) {
        if (check[v]) {
            return;
        }
        check[v] = true;
        for (int vv : list[v]) {
            if (!check[vv]) {
                friends[vv] = v;
                dfs(vv);
            }

        }

    }

    public static void main(String[] args) {
//        int[] re = solution(5, new int[][]{{1, 2}, {4, 2}, {3, 1}, {4, 5}});
        int[] re = solution(7, new int[][]{{1,2}, {4,2}, {3, 1}, {4, 5},{6,7}});

        System.out.println(re);
    }
}
