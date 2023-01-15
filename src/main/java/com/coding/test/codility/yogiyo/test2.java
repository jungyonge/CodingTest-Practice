package com.coding.test.codility.yogiyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test2 {

    static String[][] map;
    static int n;
    static int m;
    static int[][] visited;
    static int[][] tryCount;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;


    public static int solution(String[] R) {

        map = new String[R.length][R[0].length()];
        visited = new int[R.length][R[0].length()];
        tryCount = new int[R.length][R[0].length()];
        n = R[0].length();
        m = R.length;

        for (int i = 0; i < R.length; i++) {
            String[] mapInfo = R[i].split("");
            for (int j = 0; j < mapInfo.length; j++) {
                map[i][j] = mapInfo[j];
            }
        }

        cnt = 0;
        visited[0][0] = 1;
        cnt++;
        bfs(0, 0, 0);
        return cnt;
    }

    public static void bfs(int x, int y, int d) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, d});

        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[1];
            int nowY = now[0];
            int nowDirection = now[2];
            tryCount[nowY][nowX] = tryCount[nowY][nowX] + 1;

            for (int i = nowDirection; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || map[nextY][nextX].equals("X")) {
                    if (tryCount[nowY][nowX] != 4 && i == 3) {
                        q.add(new int[]{nowY, nowX, 0});
                    }
                    continue;
                }
                if (visited[nextY][nextX] == 1) {
                    int jumpY = nextY + dy[i];
                    int jumpX = nextX + dx[i];
                    if (jumpX > 0 && jumpY > 0 && jumpX <= n && jumpY <= m && !map[jumpY][jumpX].equals("X")) {
                        if (visited[jumpY][jumpX] == 0) {
                            q.add(new int[]{nextY, nextX, i});
                        }
                    }
                    break;
                }
                visited[nextY][nextX] = visited[nextY][nextX] + 1;
                q.add(new int[]{nextY, nextX, i});
                cnt++;
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"...X..", "....XX", "..X..."}));
        System.out.println(solution(new String[]{"....X..", "X......", ".....X.", "......."}));
        System.out.println(solution(new String[]{"...X.", ".X..X", "X...X", "..X.."}));
        System.out.println(solution(new String[]{"."}));

    }
}
