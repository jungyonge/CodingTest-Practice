package com.coding.test.programmers.hashcodingtest;

import java.util.HashMap;
import java.util.Map;

public class Ex_3 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/42578
//    위장

    public static int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> gearHashMap = new HashMap<>();

        for(String[] arr : clothes){
            gearHashMap.put(arr[1], gearHashMap.getOrDefault(arr[1],0) + 1);
        }

        for(int i = 0 ; i < gearHashMap.size(); i++){

        }

        return answer;
    }

    public static void main(String[] args) {

        solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }
}
