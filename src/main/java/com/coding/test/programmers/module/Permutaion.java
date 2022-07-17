package com.coding.test.programmers.module;

import java.util.ArrayList;
import java.util.List;

public class Permutaion {

    /**
     * 순열 구하기
     * 주어진 배열에서 n개 뽑을 경우의수
     * 중복허용
     * ex: 4개의 리스트에서 2개씩 뽑은 경우의 수
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
        arr.add("4");
        arr.add("1");
        arr.add("7");
        arr.add("7");
        arr.add("2");
        arr.add("5");
        arr.add("2");
        arr.add("8");
        arr.add("4");
        arr.add("1");



        List<String> temp = new ArrayList<>();
        List<String> result = new ArrayList<>();

        reculsion(arr, temp, result, arr.size(), 6);
        System.out.println(result.toString());
    }
}
