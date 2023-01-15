package com.coding.test.codility.yogiyo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class test5 {

    static int[][] map;
    static int n;
    static int m;
    static int[][] visited;
    static int[][][] tryCount;
    static int[] dx = {1, -1, 0, 0}; //동 서 남 북
    static int[] dy = {0, 0, 1, -1};
    static int cnt = 0;


    public static int solution(int[][] board) {
        int answer = -1;
        n = board[0].length;
        m = board.length;

        map = new int[m][n];
        visited = new int[m][n];
        tryCount = new int[m][n][4];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                map[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                move(j, i);
            }
        }

        if (cnt != 0) {
            answer = cnt;
        }

        return answer;
    }

    public static void move(int x, int y) {

        for (int i = 0; i < 4; i++) {

            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX < 0 || moveY < 0 || moveX >= n || moveY >= m) {
                continue;
            }
            if (tryCount[y][x][i] == 0) {
                int nextI = 0;
                if (i == 0) {
                    nextI = 1;
                } else if (i == 1) {
                    nextI = 0;
                } else if (i == 2) {
                    nextI = 3;
                } else if (i == 3) {
                    nextI = 2;
                }
                tryCount[y][x][i] = 1;
                tryCount[moveY][moveX][nextI] = 1;
            } else {
                continue;
            }

            int[][] copyMap = new int[map.length][map[0].length];
            int[][] originMap = new int[map.length][map[0].length];

            for (int j = 0; j < map.length; j++) { // 반복문 + ArrayCopy
                System.arraycopy(map[j], 0, copyMap[j], 0, copyMap[j].length);
                System.arraycopy(map[j], 0, originMap[j], 0, originMap[j].length);
            }

            int num1 = originMap[moveY][moveX];
            int num2 = originMap[y][x];

            copyMap[y][x] = num1;
            copyMap[moveY][moveX] = num2;
            if (check(copyMap, x, y) || check(copyMap, moveX, moveY)) {
                System.out.println(y + " " + x);
                cnt++;
            }
        }
    }

    public static boolean check(int[][] mapInfo, int x, int y) {
        int prev = mapInfo[y][0];
        int serial = 1;
        for (int i = 1; i < mapInfo[y].length; i++) {
            if (prev != mapInfo[y][i]) {
                prev = mapInfo[y][i];
                if (serial < 3) {
                    serial = 1;
                }
            } else {
                serial++;
            }
        }
        if (serial >= 3) {
            return true;
        }

        prev = mapInfo[0][x];
        serial = 1;
        for (int i = 1; i <  mapInfo.length; i++) {
            if (prev != mapInfo[i][x]) {
                prev = mapInfo[i][x];
                if (serial < 3) {
                    serial = 1;
                }
            } else {
                serial++;
            }
        }
        if (serial >= 3) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
//
//        System.out.println(
//                solution(new int[][]{{1, 1, 4, 3}, {3, 2, 1, 4}, {3, 1, 4, 2}, {2, 1, 3, 3}}));
        System.out.println(
                solution(new int[][]{{1, 2, 1, 2}, {3, 4, 3, 4}, {1, 2, 1, 2}, {3, 4, 3, 4}}));
    }
}
