package com.coding.test.supercat;

import java.util.Arrays;

public class test4 {

    static int max_x;

    static int max_y;
    static String[][] map;
    static boolean[][] visited;
    static int max = -1;
    public static int solution(String[] cells) {
        int answer = 0;
        map = new String[cells.length][cells[0].length()];
        visited = new boolean[cells.length][cells[0].length()];
        max_x = cells[0].length();
        max_y = cells.length;

        for(int i = 0 ; i < cells.length; i ++){
            String[] alphaArr = cells[i].split("");
            for(int j = 0 ; j < alphaArr.length; j ++){
                map[i][j] = alphaArr[j];
            }
        }

        //x
        for(int i = 0 ; i < cells[0].length(); i ++){
            //y
            for(int j = 0 ; j < cells.length; j ++){
                if(map[j][i].equals("A")){
                    visited[j][i] = true;
                    int[] eastNode = move_east(j,i);
                    int[] southNode = move_south(j, eastNode[1]);
                    int[] westNode = move_west(southNode[0],southNode[1]);
                    int[] northNode = move_north(westNode[0], westNode[1]);
                    if(eastNode[0] == northNode[0] &&
                            eastNode[1] == southNode[1] &&
                            southNode[0] == westNode[0] &&
                            westNode[1] == northNode[1]){
                        if(Math.abs(eastNode[1] - northNode[1]) > 1 &&
                                Math.abs(eastNode[0] - southNode[0]) > 1  &&
                                Math.abs(southNode[1] - westNode[1]) > 1 &&
                                Math.abs(westNode[0] - northNode[0]) > 1 ){
                            int sum = eastNode[0] + southNode[0] ;
                            sum = sum + southNode[1] + westNode[1];
                            sum = sum + westNode[0] + northNode[0] + 1;
                            max = Math.max(max, sum);
                        }


                    }
                    visited = new boolean[cells.length][cells[0].length()];

                }
            }
        }


        return max;
    }


    public static int[]  move_east(int y, int x){
        int nextX = x;
        while (true){
            nextX = nextX + 1;
            if(nextX >= max_x){
                break;
            }
            if (visited[y][nextX] || !map[y][nextX].equals("A")){
                break;
            }
            visited[y][nextX] = true;
        }
        return new int[]{y, nextX - 1};
    }

    public static int[] move_south(int y, int x){
        int nextY = y;
        while (true){
            nextY = nextY + 1;
            if(nextY >= max_y){
                break;
            }
            if (visited[nextY][x] || !map[nextY][x].equals("A")){
                break;
            }
            visited[nextY][x] = true;
        }
        return new int[]{nextY - 1, x};
    }

    public  static int[] move_west(int y, int x){
        int nextX = x ;
        while (true){
            nextX = nextX - 1;
            if(nextX < 0){
                break;
            }
            if (visited[y][nextX] || !map[y][nextX].equals("A")){
                break;
            }
            visited[y][nextX] = true;
        }
        return new int[]{y, nextX + 1};
    }



    public static int[] move_north(int y, int x){
        int nextY = y;
        while (true){
            nextY = nextY - 1;
            if(nextY < 0){
                break;
            }
            if (visited[nextY][x] || !map[nextY][x].equals("A")){
                break;
            }
            visited[nextY][x] = true;
        }
        return new int[]{nextY + 1, x};
    }


    public static void main(String[] args) {

        System.out.println(solution(new String[]{"AAA","AAA","AAA","AAA"}));
//        System.out.println(solution(new String[]{"BAA","ABB","ABB","AAA"}));

    }
}
