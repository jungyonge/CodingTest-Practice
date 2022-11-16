package com.coding.test.programmers.codingtest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PG_135808 {
//https://school.programmers.co.kr/learn/courses/30/lessons/135808

    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] tmp = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder()); // 내림차순

        int boxCount = tmp.length / m;

        for(int i = 0 ; i < boxCount; i ++){
            int max = tmp[((i + 1) * m) -1];
            answer = answer + (max * m);
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(4,3, new int[] {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2});
    }
}
