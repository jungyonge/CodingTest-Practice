package com.coding.test.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576 {


    //게임맵
    //좌표
    //bfs
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int[] checkCount = new int[1000];
    static int count = 0;
    static int x,y = 0;
    static int nowCount = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<int[]> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
         x = Integer.parseInt(st.nextToken());
         y = Integer.parseInt(st.nextToken());
        map = new int[y][x];
        visited = new boolean[y][x];
        for(int i = 0 ; i < y ;i ++){
            String[] temp = br.readLine().split(" ");
            for(int j = 0 ; j < x ; j ++){
                map[i][j] = Integer.parseInt(temp[j]);
                if(map[i][j] == 1){
                    q.add(new int[] {i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        bfs();

        for(int i = 0 ; i < y ;i ++){
            for(int j = 0 ; j < x ; j ++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(nowCount);

    }

    public static void bfs() {

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            nowCount = now[2];
            boolean check = false;
            checkCount[nowCount] = 1;
            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= y || nextY >= x)
                    continue;
                if (visited[nextX][nextY])
                    continue;

                if(map[nextX][nextY] == 0){
                    check = true;
                    map[nextX][nextY] = 1;
                    q.add(new int[] {nextX, nextY, nowCount + 1});
                    visited[nextX][nextY] = true;
                }
            }


        }
    }

}
