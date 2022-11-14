package com.coding.test.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2667 {
    //dfs
    //맵 구역 찾기
    //그래프

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int[] x = {0, 1, -1, 0};
    static int[] y = {1, 0, 0, -1};
    static int count = 0;
    static Queue<int[]> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        map = new int[size][size];
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            String[] tempMap = st.nextToken().split("");
            for (int j = 0; j < tempMap.length; j++) {
                map[i][j] = Integer.parseInt(tempMap[j]);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(Integer temp : result){
            System.out.println(temp);
        }

    }

    public static void dfs(int curX, int curY) {
        visited[curX][curY] = true;

        for (int i = 0; i < 4; i++) {

            int newX = curX + x[i];
            int newY = curY + y[i];
            if (newX >= 0 && newY >= 0 && newX < map.length && newY < map[0].length) {
                if (map[newX][newY] != 0 && !visited[newX][newY]) {
                    dfs(newX, newY);
                    count++;

                }
            }
        }
    }
}
