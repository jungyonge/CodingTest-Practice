package com.coding.test.programmers.module;

import java.util.ArrayList;
import java.util.List;

public class AllPermutation {
    /**
     * 순열 구하기
     * 주어진 배열 전체 경우의
     * 중복허용
     * @param arr    : 기준 리스트
     * @param result : 결과를 담아줄 리스트용
     * @param n      : 전체 갯수
     * @param r      : 뽑을 갯수
     */

    private static void reculsion(List<String> arr, List<String> temp, List<String> result, int n, int r) {


        if (r == 0) {
            result.add(temp.toString());
            return ;
        }

        for (int i = 0; i < n; i++) {
            temp.add(arr.remove(i));
            reculsion(arr, temp, result, n - 1, r - 1);
            arr.add(i, temp.remove(temp.size() - 1));
        }

    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("d");


        List<String> temp = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            reculsion(arr, temp, result, arr.size(), i+1);
        }
        System.out.println(result.toString());
    }
}
