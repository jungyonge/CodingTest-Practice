package com.coding.test.programmers.dfsbfscodingtest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ex_3 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/1844
//    게임맵 최단거리
//    bfs

        static int[] x = {0,1,-1,0};
        static int[] y = {1,0,0,-1};
        static int min = Integer.MAX_VALUE;
        public static int solution(int[][] maps) {
            bfs(maps);
            return min != Integer.MAX_VALUE ? min : -1;
        }

        public static void bfs(int[][] maps) {

            boolean[][] visited = new boolean[maps.length][maps[0].length];
            Queue<int[]> q = new LinkedList<>();
            int[] cur = {0,0,1};
            q.add(cur);
            visited[0][0] = true;
            while(!q.isEmpty()) {
                int[] current = q.poll();
                System.out.println("poll : " + Arrays.toString(current));


                if(current[0] == maps.length - 1 && current[1] == maps[0].length - 1) {
                    min = Math.min(min, current[2]);
                    return;
                }

                for(int i = 0; i < 4; i++) {
                    int newX = current[0] + x[i];
                    int newY = current[1] + y[i];
                    int count = current[2] + 1;

                    if(newX >= 0 && newY >= 0 && newX < maps.length && newY < maps[0].length) {

                        if(maps[newX][newY] != 0 && !visited[newX][newY]) {
                            visited[newX][newY] = true;
                            int[] newCur = new int[3];
                            newCur[0] = newX;
                            newCur[1] = newY;
                            newCur[2] = count;
                            System.out.println("add : " + Arrays.toString(newCur));
                            q.add(newCur);
                        }
                    }
                }
            }
        }

    public static void main(String[] args) {

        System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }

}
