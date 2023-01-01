package com.coding.test.supercat;

import java.util.Arrays;

public class test2_5 {
    static int count = 0;
    static double now_load;
    static boolean[] visited;

    public static int solution(int M, int[] load) {
        visited = new boolean[load.length];
        Arrays.sort(load);
        if (load[load.length - 1] > M) {
            return -1;
        }

        if(load.length > 12){
            return -1;
        }

        if(M > 40 || M < 0 ){
            return -1;
        }



        for (int i = load.length - 1; i >= 0; i--) {
            if(load[i] > 40 || load[i] < 0){
                return -1;
            }
            if (!visited[i] && load[i] != 0) {
                visited[i] = true;
                now_load = load[i];
                dfs(i - 1, M, load);
                count++;
                now_load = 0;
            }
        }

        for (boolean b : visited) {
            if (!b) {
                return -1;
            }
        }

        return count;
    }

    public static void dfs(int startAt ,int M, int[] load) {
        if (now_load == M) {
            return;
        }

        for (int i = startAt; i >= 0; i--) {
            if (!visited[i] && now_load + load[i] <= M) {
                visited[i] = true;
                now_load = now_load + load[i];
                if(now_load <= M){
                    dfs( i - 1, M, load);
                }
            }
        }
    }


    public static void main(String[] args) {
        int M = 10;
        int[] arr = new int[]{1,2,5,8,9};
        int re = solution(M, arr);
        System.out.println(re);
    }
}
