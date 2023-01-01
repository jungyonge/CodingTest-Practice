package com.coding.test.supercat;

import java.util.Arrays;

public class test2_2 {
    static double now_load;
    static boolean[] visted;

    public static int solution(int M, int[] load)  {
        int answer = 0, last = load.length - 1;

        Arrays.sort(load);
        visted = new boolean[load.length];
        int first = 0;
        for(int i = load.length - 1 ; i >= 0 ; i--) {
            if(!visted[i] && now_load + load[i] <= M){
                answer++;
                visted[i] = true;
                now_load = load[i];
                while (first <= i) {
                    if(now_load == M){
                        break;
                    }
                    if(!visted[first] && now_load + load[first] > M){
                        break;
                    }
                    if(!visted[first] && now_load + load[first] <= M){
                        visted[first] = true;
                        now_load = now_load + load[first];
                    }
                    first++;
                }
                now_load = 0;
            }

        }

        for(int i = 0 ; i < visted.length ; i++){
            if(!visted[i]){
                return -1;
            }
        }

        return answer;
    }

    static int count = 0;

    public static int solution1(int M, int[] load) {
        int answer = 0;
        visted = new boolean[load.length];
        Arrays.sort(load);
        if(load[load.length -1] > M){
            return -1;
        }
        for(int i = load.length - 1 ; i >= 0 ; i--){
            if(!visted[i] && load[i] != 0){
                visted[i] = true;
                now_load = load[i];
                if(now_load <= M){
                    dfs(0, M, load);
                    count++;
                } else if (now_load > M) {
                    visted[i] = false;
                }
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

    public static void dfs(int startAt ,int M, int[] load){
        if(now_load == M){
            return;
        }

        for(int i = startAt ; i < visted.length; i ++){
            if(!visted[i]){
                visted[i] = true;
                if(now_load + load[i] <= M){
                    now_load = now_load + load[i];
                    dfs(i + 1, M, load);
                }else if(now_load + load[i] > M){
                    visted[i] = false;
                    break;
                }

            }
        }
    }


    public static void main(String[] args) {
        int M = 99;
        int[] arr = new int[]{99,99,99,99};
        int re = solution( M,arr);
        System.out.println(re);
        re = solution1(M, arr);
        System.out.println(re);
    }
}
