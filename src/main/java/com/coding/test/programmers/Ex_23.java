package com.coding.test.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex_23 {

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();

        result = getDiv(brown + yellow);
        if(result.size() == 2){
            answer = new int[]{result.get(1),result.get(1)};
        }else {
            result = getRes(result,brown);
            answer = new int[]{result.get(0),result.get(1)};
        }
        return answer;
    }

    private static ArrayList<Integer> getDiv(int num){
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 1; i < num; i++) {
            if(num % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    private static ArrayList<Integer> getRes(ArrayList<Integer> numArr, int brown) {

        int checkBrown = 0;
        int garo = 0;
        int sero = 0;
        int i = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (brown != checkBrown){
            garo = numArr.get(numArr.size()/2 + 1 + i);
            sero = numArr.get(numArr.size()/2- i);
            checkBrown = ( garo + sero - 2) * 2;
            i++;
        }
        result.add(garo);
        result.add(sero);
        return result;
    }
    public static void main(String[] args) {
        int brown = 8;
        int yellow =1;
        solution(brown,yellow);
    }
}
