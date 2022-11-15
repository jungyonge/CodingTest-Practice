package com.coding.test.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7562 {

    //좌표이동
    //bfs
    //최소이동

    static boolean[][] visited;
    static int[][] map;
    static int size;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static LinkedList<Integer> result = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < cnt ; i++){
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            visited = new boolean[size][size];
            map = new int[size][size];
            st = new StringTokenizer(br.readLine());
            int startX =  Integer.parseInt(st.nextToken());
            int startY =  Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX =  Integer.parseInt(st.nextToken());
            int endY =  Integer.parseInt(st.nextToken());
            bfs(startX,startY,endX,endY);
        }

        for(Integer i : result){
            System.out.println(i);
        }
    }

    public static void bfs(int x, int y,int endX,int endY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        visited[x][y] = true;
        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            if(nowX == endX && nowY == endY){
                result.add(map[nowX][nowY]);
                return;
            }

            for(int i=0; i<8; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size)
                    continue;
                if (visited[nextX][nextY])
                    continue;

                q.add(new int[] {nextX, nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;

            }
        }
    }
}
