package com.coding.test.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//DFS 2중배열 최대크기, 길찾기
public class Ex_38 {
    static int picCnt;
    public static int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        boolean[][] visited = new boolean[m][n];
        int maxCnt = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(picture[i][j] > 0 && !visited[i][j]) {
                    picCnt = 0;
                    answer[0]++;
                    dfs(m, n, picture, i, j, picture[i][j], visited);
                    if(picCnt > maxCnt){
                        maxCnt = picCnt;
                    }
                }
            }
        }
        answer[1] = maxCnt;
        System.out.println(Arrays.toString(answer));

        return answer;
    }
    static void dfs(int m, int n, int[][] picture, int x, int y, int num, boolean[][] visited) {
        if(visited[x][y] || picture[x][y] != num) return;
        picCnt++;
        visited[x][y] = true;

        if(0 <= x-1) {
            dfs(m, n, picture, x-1, y, num, visited);
        }
        if(x+1 < m) {
            dfs(m, n, picture, x+1, y, num, visited);
        }
        if(0 <= y-1) {
            dfs(m, n, picture, x, y-1, num, visited);
        }
        if(y+1 < n) {
            dfs(m, n, picture, x, y+1, num, visited);
        }
    }



    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        solution(m, n, picture);
    }
}

