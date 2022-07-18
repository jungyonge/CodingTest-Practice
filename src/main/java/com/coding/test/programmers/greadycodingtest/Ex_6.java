package com.coding.test.programmers.greadycodingtest;

import java.util.Arrays;

public class Ex_6 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/42884
//    단속카메라

    public static int solution(int[][] routes) {
        // 끝나는 시간 순 대로 오름차순 정렬
        Arrays.sort(routes, (a,b)-> Integer.compare(a[1], b[1]));
        int cnt = 0;

        int min = Integer.MIN_VALUE;
        for(int[] route : routes) {
            if(min <  route[0] ) {
                // 전 거의 끝나는 시간 보다 시작 시간이 큰 경우
                // 안 겹치니까 변경하고, 숫자 더하기
                min = route[1];
                System.out.println(min);
                ++cnt;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}});
    }
}
