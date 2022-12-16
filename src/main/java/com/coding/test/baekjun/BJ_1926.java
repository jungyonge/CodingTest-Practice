package com.coding.test.baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1926 {

    static int[][] map;
    static int map_x;
    static int map_y;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
    static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우
    static int map_count = 0;
    static int MAX_MAP = 0;
    static int temp_Map = 0 ;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        map_y = in.nextInt();
        map_x = in.nextInt();
        map = new int[map_y][map_x];
        visited = new boolean[map_y][map_x];

        for(int i = 0 ; i < map_y; i ++){
            for(int j = 0 ; j < map_x; j ++){
                map[i][j]= in.nextInt();
            }
        }

        for(int i = 0 ; i < map_y; i ++){
            for(int j = 0 ; j < map_x; j ++){
                if(map[i][j] == 1 && !visited[i][j] ){
                    bfs(i, j);
                    map_count++;
                    MAX_MAP = Math.max(MAX_MAP,temp_Map);
                    temp_Map = 0;
                }
            }
        }

        System.out.println(map_count);
        System.out.println(MAX_MAP);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        visited[x][y] = true;

        temp_Map++;

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= map_y || nextY >= map_x)
                    continue;
                if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                    continue;

                q.add(new int[] {nextX, nextY});
                temp_Map++;
                visited[nextX][nextY] = true;
            }
        }
    }
}
