package com.coding.test.programmers;

import java.util.Arrays;

public class Ex_24 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int matchNums = 0;
        int zeroCnt = 0;
        int predicMax = 0;
        int predicMin = 0;

        for(int lotto : lottos){
            for(int win_num : win_nums ){
                if(win_num == lotto){
                    matchNums++;
                }
            }
            if (lotto == 0){
                zeroCnt++;
            }
        }

        predicMax = matchNums + zeroCnt;
        if (zeroCnt == 0){
            predicMin = 6;
        }else {
            predicMin = matchNums;
        }

        answer = new int[]{getWin(predicMax), getWin(predicMin)};


        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static int getWin(int num){
        if(num == 6){
            return 1;
        }else if( num == 5){
            return 2;
        }else if( num == 4){
            return 3;
        }else if( num == 3){
            return 4;
        }else if( num == 2){
            return 5;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = 	{31, 10, 45, 1, 6, 19};
        solution(lottos,win_nums);
    }
}
