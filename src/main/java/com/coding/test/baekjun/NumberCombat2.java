package com.coding.test.baekjun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberCombat2 {


    /**
     * 조합 구하기
     *
     * @param arr    : 기준 리스트
     * @param result : 결과를 담아줄 리스트
     * @param index  : 반복문 시작 인덱스
     * @param n      : 전체 갯수
     * @param r      : 뽑을 갯수
     */
    private static void reculsion(List<String> arr, List<String> temp, List<String> result,
            int index, int n, int r) {

        if (r == 0) {

            result.add(temp.toString());
            return;
        }

        for (int i = index; i < n; i++) {

            temp.add(arr.get(i));
            reculsion(arr, temp, result, i + 1, n, r - 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {

        List<String> arr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int cnt2 = scanner.nextInt();
        for(int i = 0; i < cnt ; i ++){
            arr.add(String.valueOf(i + 1));
        }


        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        reculsion(arr, temp, result, 0, arr.size(), cnt2);
        Collections.sort(result);
        for(String s : result){
            System.out.println(s.replace("[","").replace("]","").replace(",",""));
        }    }

}

