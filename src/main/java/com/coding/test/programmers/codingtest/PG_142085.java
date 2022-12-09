package com.coding.test.programmers.codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PG_142085 {

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int max = Arrays.stream(enemy).max().getAsInt();
        LinkedHashMap<Integer,Integer> numCnt = new LinkedHashMap<>();
        for(int i = 0 ; i < enemy.length - 1 ; i++){
            numCnt.put(enemy[i],numCnt.getOrDefault(enemy[i],0) + 1);
        }

        for(int i = 0 ; i < k ; i++){
            int cnt = numCnt.get(max);

        }

        return answer;
    }

    public static void main(String[] args) {
        solution(7,3, new int[] {4, 2, 4, 5, 3, 3, 1});
    }
}
