package com.coding.test.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static int min;
    static int size;
    public static int[] arr;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        map = new int[size][3];
        arr = new int[3];
        for(int i = 0 ; i < size ; i ++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < 3 ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        System.out.println(min);
    }

    public static void dfs(int before, int depth){

        if(depth == size){
            int sum = 0;
            for(int i : arr){
                sum += i;
            }
            min = Math.min(sum,min);
        }

        for(int i = 0 ; i < size; i ++){
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
//1 2 1
//1 2 3
//1 3 1
//1 3 2
//2 1 2
//2 1 3
//2 3 1
//2 3 2
//3 1 3
//3 1 2
//3 2 1
//3 2 3