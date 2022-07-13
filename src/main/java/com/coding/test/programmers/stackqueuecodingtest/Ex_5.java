package com.coding.test.programmers.stackqueuecodingtest;

import java.util.LinkedList;
import java.util.*;
import java.util.stream.Collectors;

public class Ex_5 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/12906
//    같은 숫자는 싫어

    public static int[] solution(int[] arr) {
        int[] answer = {};

        List<Integer> intList = new ArrayList<>();

        int time = 0;
        for(int i = 0 ; i < arr.length; i++){
            int now = arr[i];
            int next = 0;

            if(i == arr.length - 1){
                if(intList.get(intList.size() - 1) != now){
                    intList.add(now);
                }
            }

            for(int j = i + 1; j <  arr.length; j++){
                next = arr[j];
                if(now != next || j == arr.length - 1){
                    intList.add(now);
                    i = j -1 ;
                    break;
                }
            }
        }
        answer = intList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }

    public static void main(String[] args) {

        solution(new int[]{1,0,0,0});
    }
}
