package com.coding.test.programmers.codingtest;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class PG_70129 {


    public static int[] solution(String s) {
        int[] answer = {};
        String temp = "";
        int cnt = 0;
        int result = 0;
        int removeZero = 0;
        String[] tempArr ;
        StringBuilder sb = new StringBuilder();
        while (true){
            tempArr = s.split("");

            for(String t : tempArr){
                if(t.equals("1")){
                    cnt++;
                }else {
                    removeZero++;
                }
            }

            if(cnt == 0 ){
                temp = Integer.toBinaryString(tempArr.length);

            }else {
                temp = Integer.toBinaryString(cnt);

            }


            cnt = 0;
            s = temp;
            result++;
            if(temp.equals("1")){
                break;
            }
        }

        return new int[]{result, removeZero};
    }
    public static void main(String[] args) {
        solution("1111111");
    }
}
