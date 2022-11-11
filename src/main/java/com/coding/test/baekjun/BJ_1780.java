package com.coding.test.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_1780 {


    // 색상 카운트 할 변수 및 색종이(board)
    // 색종이 분할 체크
    // 재귀 분할 정 복
    public static int white = 0;
    public static int blue = 0;
    public static int[][] board;
    public static StringBuilder sb = new StringBuilder();
    public static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(temp[j]);
            }
        }

        partition(0, 0, N);
        System.out.println(map.getOrDefault(-1,0));
        System.out.println(map.getOrDefault(0,0));
        System.out.println(map.getOrDefault(1,0));


    }

    public static void partition(int row, int col, int size) {

        //
        if (colorCheck(row, col, size)) {
            if (board[row][col] == 1) {
                map.put(1,map.getOrDefault(1,0) + 1);
            } else if(board[row][col] == 0) {
                map.put(0,map.getOrDefault(0,0) + 1);
            } else {
                map.put(-1,map.getOrDefault(-1,0) + 1);
            }
            return;
        }

        int newSize = size / 3;    // 절반 사이즈
        // 재귀 호출
        partition(row, col, newSize);                        // 2사분면
        partition(row, col + newSize, newSize);                // 1사분면
        partition(row, col + newSize + newSize, newSize);                // 1사분면

        partition(row + newSize, col, newSize);                // 3사분면

        partition(row + newSize, col + newSize, newSize);    // 4사분면
        partition(row + newSize, col + newSize + newSize, newSize);                // 3사분면
        partition(row  + newSize+ newSize, col, newSize);                // 3사분면

        partition(row + newSize+ newSize, col + newSize, newSize);    // 4사분면
        partition(row + newSize+ newSize, col + newSize + newSize, newSize);                // 3사분면



    }


    // 현재 파티션의 컬러가 같은지 체크한다.
    public static boolean colorCheck(int row, int col, int size) {

        int color = board[row][col];    // 첫 번째 원소를 기준으로 검사

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                // 색상이 같이 않다면 false를 리턴
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        // 검사가 모두 통과했다는 의미이므로 true 리턴
        return true;
    }
}
