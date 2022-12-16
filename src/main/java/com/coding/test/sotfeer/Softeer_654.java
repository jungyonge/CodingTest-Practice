package com.coding.test.sotfeer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Softeer_654 {

    static int[] bus_array ;
    static int bus_count;
    static int condition_num = 3;
    static int result = 0;
    static int[] arr = new int[3];
    static boolean[] visited ;
    static Integer dp[];
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        bus_count = in.nextInt();
        bus_array = new int[bus_count];
        visited = new boolean[bus_count];
        for(int i = 0 ; i < bus_count ; i ++){
            bus_array[i] = in.nextInt();
        }
        LinkedList<int[]> list = new LinkedList<>();
        for(int i = 0; i < bus_count - 2 ; i++){
            for(int j = i + 1 ; j < bus_count - 1; j ++){
                if(bus_array[i] < bus_array[j]){
                    list.add(new int[]{bus_array[i],bus_array[j],j + 1});

                }
            }
        }

        for(int[] temp : list){
            for(int i = temp[2] ; i < bus_count ; i++){
                if(temp[0] > bus_array[i]){
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static int find(int N) {
        if(N < 0){
            return -1;
        }

        // 아직 탐색하지 않는 N번째 계단일 경우
        if(dp[N] == null) {
            dp[N] = Math.min(find(N-3), find(N-5));
        }

        return dp[N];
    }

    public static void dfs(int start_at, int depth, int[] temp_arr){
        if(depth == 3){
            if(temp_arr[0] < temp_arr[1] && temp_arr[0] > temp_arr[2]){
                result++;
            }
            return;
        }
        if(depth == 2 && temp_arr[0] > temp_arr[1]){
            return;
        }

        for(int i = start_at ; i < bus_count ; i ++){
            if(!visited[i]){
                visited[i] = true;
                temp_arr[depth] = bus_array[i];

                dfs(i + 1, depth + 1, temp_arr);
                visited[i] = false;
            }
        }

    }

}
