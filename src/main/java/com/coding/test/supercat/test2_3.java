package com.coding.test.supercat;

import java.util.Arrays;

public class test2_3 {


    static int count = 0;
    static double now_load;
    static boolean[] visted;

    public static int solution1(int M, int[] load) {
        int answer = 0;
        visted = new boolean[load.length];
        Arrays.sort(load);
        if (load[load.length - 1] > M) {
            return -1;
        }
        for (int i = load.length - 1; i >= 0; i--) {
            if (!visted[i] && load[i] != 0) {
                visted[i] = true;
                now_load = load[i];
                dfs(i - 1, M, load);
                count++;
                now_load = 0;
            }

        }
        for (boolean b : visted) {
            if (!b) {
                return -1;
            }
        }

        return count;
    }

    public static void dfs(int startAt, int M, int[] load) {
        if (now_load == M) {
            return;
        }

        for (int i = startAt; i >= 0; i--) {
            if (!visted[i] && now_load + load[i] <= M) {
                visted[i] = true;
                now_load = now_load + load[i];
                if(now_load < M){
                    dfs(i - 1, M, load);
                }
                return;
            } else if (now_load + load[i] > M) {
                dfs(i - 1, M, load);
            }
        }
    }

//    public static int solution1(int M, int[] load) {
//        int answer = 0;
//        Arrays.sort(load);
//        for (int i = load.length - 1; i >= 0; i--) {
//            if (!visted[i] && load[i] != 0) {
//                visted[i] = true;
//                now_load = load[i];
//                count++;
//                now_load = 0;
//            }
//
//        }
//        return answer;
//    }

    public static void main(String[] args) {
        int M = 15;
        int[] arr = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,7,7,8,8};
        int re = solution1(M, arr);
        System.out.println(re);
    }

}
