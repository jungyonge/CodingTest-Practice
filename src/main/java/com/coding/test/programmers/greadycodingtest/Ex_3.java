package com.coding.test.programmers.greadycodingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex_3 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/42883
//    큰 수 만들기

    static int max = 0;
    public static String solution(String number, int k) {
        String answer = "";

        List<String> arr = new ArrayList<>();

        for(int i = 0 ; i < number.length() ; i ++){
            arr.add(String.valueOf(number.charAt(i)));
        }

        List<String> temp = new ArrayList<>();
        List<String> result = new ArrayList<>();

        int r = arr.size() - k;
        reculsion(arr, temp, result, 0, arr.size(), r);


        answer = String.valueOf(max);
        return answer;
    }
    private static void reculsion(List<String> arr, List<String> temp, List<String> result, int index, int n, int r) {

        if (r == 0) {
            StringBuilder tempSb = new StringBuilder();
            for(String str : temp){
                tempSb.append(str);
            }
            if(Integer.parseInt(tempSb.toString()) > max){
                max = Integer.parseInt(tempSb.toString());
            }
            return;
        }

        for (int i = index; i < n; i++) {

            temp.add(arr.get(i));
            reculsion(arr,temp, result, i + 1, n, r - 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {

        solution("4177252841", 4);
    }
}
