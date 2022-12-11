package com.coding.test.baekjun.basicmodule;

import java.util.Scanner;

public class DFS_ISLAND_COUNT {

    //좌표이동
    //섬 개수
    //섬의 개수 구하기
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, -1, 0 , -1, 1 , 1 ,-1};
    static int[] dy = {1, 0, 0, -1,  1 , -1, 1 , -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            int count = 0 ;
            String stTemp = scanner.nextLine();
            if(stTemp.equals("0 0")){
                break;
            }

            String[] mapSize = stTemp.split(" ");
            map = new int[Integer.parseInt(mapSize[1])][Integer.parseInt(mapSize[0])];
            visited = new boolean[Integer.parseInt(mapSize[1])][Integer.parseInt(mapSize[0])];

            for(int i = 0 ; i < Integer.parseInt(mapSize[1]) ; i++){
                String[] mapInfo = scanner.nextLine().split(" ");

                for (int j = 0 ; j < Integer.parseInt(mapSize[0]); j++){
                    map[i][j] = Integer.parseInt(mapInfo[j]);
                }
            }

            for(int i = 0 ; i < Integer.parseInt(mapSize[1]) ; i++){

                for (int j = 0 ; j < Integer.parseInt(mapSize[0]); j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);


        }


    }

    public static void dfs(int curX, int curY) {
        visited[curX][curY] = true;

        for (int i = 0; i < 8; i++) {

            int newX = curX + dx[i];
            int newY = curY + dy[i];
            if (newX >= 0 && newY >= 0 && newX < map.length && newY < map[0].length) {
                if (map[newX][newY] ==1 && !visited[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }
    }

}
