package com.coding.test.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1012 {

    //dfs
    //맵 구역 찾기
    //그래프
    //좌표이동

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
        int cnt = Integer.parseInt(st.nextToken());
        ArrayList<Integer> result1 = new ArrayList<>();

        for(int ni = 0 ; ni < cnt ; ni++){
            st = new StringTokenizer(br.readLine());
            int sizeX = Integer.parseInt(st.nextToken());
            int sizeY = Integer.parseInt(st.nextToken());
            int cntVag = Integer.parseInt(st.nextToken());
            map = new int[sizeX][sizeY];
            visited = new boolean[sizeX][sizeY];
            for(int nj = 0 ; nj < cntVag ; nj++){
                st = new StringTokenizer(br.readLine());
                int tempX = Integer.parseInt(st.nextToken());
                int tempY = Integer.parseInt(st.nextToken());
                map[tempX][tempY] = 1;
            }

            ArrayList<Integer> result = new ArrayList<>();

            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeY; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        count = 1;
                        dfs(i, j);
                        result.add(count);
                    }
                }
            }
            result1.add(result.size());
        }

        for(Integer temp : result1){
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
