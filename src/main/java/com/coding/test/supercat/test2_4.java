package com.coding.test.supercat;

import java.util.Arrays;

public class test2_4 {

    static int count = 0;
    static double now_load;
    static boolean[] visited;

    public static int solution(int M, int[] load) {
        int answer = 0;
        visited = new boolean[load.length];
        Arrays.sort(load);
        if (load[load.length - 1] > M) {
            return -1;
        }


        for (int i = load.length - 1; i >= 0; i--) {
            if(!visited[i] && load[i] <= M){
                visited[i] = true;
                now_load = load[i];

                if(now_load == M){
                    break;
                }

                for (int j = i - 1; j >= 0; j--) {
                    if(now_load == M){
                        break;
                    }
                    if(!visited[j] && now_load + load[j] <= M){
                        visited[j] = true;
                        now_load = now_load + load[j];

                    }
                }
                now_load = 0;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int M = 20;
        int[] arr = new int[]{16,15,9,17,1,3};
        int re = solution(M, arr);
        System.out.println(re);
    }
}
