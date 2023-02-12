package com.coding.test.programmers.hanhwa;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class test3 {

    //bfs
    //맵 구역 찾기
    //그래프
    //최단거리찾기
    //최단거리는 무조건 bfs

    static int[][] map;
    static boolean[][] busStopMap;
    static int MIN = Integer.MAX_VALUE;
    static int line;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; //x방향배열-상하
    static int[] dy = {0, 0, -1, 1}; //y방향배열-좌우

    public static int[][] solution(int N, int[][] bus_stop) {
        line = N;
        busStopMap = new boolean[N][N];
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int[] stop : bus_stop) {
            busStopMap[stop[0] - 1][stop[1] - 1] = true;
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                map = new int[N][N];
//                visited = new boolean[N][N];
//                MIN = Integer.MAX_VALUE;
//                visited[0][0] = true;
//                bfs(i, j);
//                answer[i][j] = MIN;
//            }
//        }

        for (int[] stop : bus_stop) {
            visited = new boolean[N][N];
            bfs(stop[0] - 1, stop[1] - 1);
        }
        return map;
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= line || nextY >= line) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }

                if (busStopMap[nextX][nextY]) {
                    continue;
                }

                if (map[nowX][nowY] + 1 < map[nextX][nextY] || map[nextX][nextY] == 0) {
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                    System.out.println(nextX + " " +  nextY);
                    q.add(new int[]{nextX, nextY});
                }

                visited[nextX][nextY] = true;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(solution(3, new int[][]{{1, 2}, {3, 3}})));
    }
}
