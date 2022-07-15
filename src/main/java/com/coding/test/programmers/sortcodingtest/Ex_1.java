package com.coding.test.programmers.sortcodingtest;

import java.util.Arrays;

public class Ex_1 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/42748
//    k번째 수


    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length ; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
    public static void main(String[] args) {

        solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }

}

