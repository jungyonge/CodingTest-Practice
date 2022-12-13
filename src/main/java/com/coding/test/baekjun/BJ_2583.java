package com.coding.test.baekjun;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_2583 {

    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int x,y,k;
    static int[][] map;
    static boolean[][] visited;
    static int block_count = 0;
    static int block_size = 0;
    static ArrayList<Integer> block_size_array = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();
        k = sc.nextInt();

        map = new int[y][x];
        visited = new boolean[y][x];

        for(int i = 0 ; i < k ; i ++){
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int endX = sc.nextInt();
            int endY = sc.nextInt();

            for(int yy = startY ; yy < endY; yy ++){
                for(int xx = startX ; xx < endX; xx ++){
                    map[yy][xx] = 1;
                }
            }
        }

        for(int i = 0 ; i < y; i++){

            for (int j = 0 ; j < x; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    block_count++;
                    dfs(i, j);
                    block_size_array.add(block_size + 1);
                    block_size = 0;
                }
            }
        }

        System.out.println(block_count);
        Collections.sort(block_size_array);
        for(Integer temp : block_size_array){
            System.out.print(temp);
            System.out.print(" ");

        }
    }
    public static void dfs(int curX, int curY) {
        visited[curX][curY] = true;

        for (int i = 0; i < 4; i++) {

            int newX = curX + dx[i];
            int newY = curY + dy[i];
            if (newX >= 0 && newY >= 0 && newX < map.length && newY < map[0].length) {
                if (map[newX][newY] == 0 && !visited[newX][newY]) {
                    block_size++;
                    dfs(newX, newY);
                }
            }
        }
    }
}
