package com.coding.test.programmers.codingtest;

public class PG_43105 {


    static Integer dp[][];
    static int arr[];
    static int max;

    public static int solution(int[][] triangle) {
        int answer = 0;
        int y = triangle.length - 1;
        int x = triangle[triangle.length - 1].length -1;
        dp = new Integer[y + 1][x + 1];
        for(int i = 0 ; i < x + 1 ; i ++){
            dp[y][i] = triangle[y][i];
        }


        return find(0,0, triangle);
    }

    static int find(int y, int x, int[][] triangle ) {
        // 아직 탐색하지 않는 N번째 계단일 경우
        if(dp[y][x] == null) {
            dp[y][x] = Math.max(find(y + 1,x , triangle),find(y+1,x + 1, triangle)) + triangle[y][x];
        }

        return dp[y][x];
    }
    public static void main(String[] args) {
        solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
    }
}
