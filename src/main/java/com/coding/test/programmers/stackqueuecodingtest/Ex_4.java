package com.coding.test.programmers.stackqueuecodingtest;

import java.util.ArrayList;
import java.util.*;

public class Ex_4 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/42584
//    주식가격


    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        List<Integer> priceList = new ArrayList<>();

        int time = 0;
        for(int i = 0 ; i < prices.length; i++){
            int now = prices[i];
            int next = 0;
            if(i == prices.length - 1 ){
                answer[i] = time;
            }
            for(int j = i + 1; j <  prices.length; j++){
                next = prices[j];
                time++;
                if(now > next || j == prices.length - 1){
                    answer[i] = time;
                    time = 0;
                    break;
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {

        solution(new int[]{1,2,3,2,3});
    }
}
