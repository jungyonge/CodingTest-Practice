package com.coding.test.baekjun;

import java.util.Scanner;

public class BJ_2468 {

    //섬의 개수 구하기
    static int[][] map;
    static boolean[][] visited;

    static int MAX = 0;

    static int MAX_HEIGHT = 0;

    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1,};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();


        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                MAX_HEIGHT = Math.max(map[i][j] , MAX_HEIGHT);
            }
        }

        for( int n = 0 ; n < MAX_HEIGHT + 1 ; n++){
            int count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > n && !visited[i][j]) {
                        dfs(i, j, n);
                        count++;
                    }
                }
            }
            MAX = Math.max(count, MAX);
        }


        System.out.println(MAX);


    }

    public static void dfs(int curX, int curY, int n) {
        visited[curX][curY] = true;

        for (int i = 0; i < 4; i++) {
            int newX = curX + dx[i];
            int newY = curY + dy[i];
            if (newX >= 0 && newY >= 0 && newX < map.length && newY < map[0].length) {
                if (map[newX][newY] > n && !visited[newX][newY]) {
                    dfs(newX, newY, n);
                }
            }
        }
    }

}
