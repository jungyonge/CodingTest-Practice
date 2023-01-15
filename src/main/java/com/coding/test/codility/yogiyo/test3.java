package com.coding.test.codility.yogiyo;

import java.util.Arrays;

public class test3 {

    static int minLength = 0;

    public static String solution(String s1, String s2) {
        String[] answer = new String[2];
        String combine = "";
        minLength = Math.min(s1.length() -1 , s2.length() -2);
        for(int i = 0 ; i < 2; i ++){
            int cnt = 0;
            if(i == 0 ){
                cnt = check(s1,s2);
                combine = s1 + s2.substring(cnt);
                answer[i] = combine;
            }else {
                cnt = check(s2,s1);
                if(combine.length() >= (s2 + s1.substring(cnt)).length()){
                    combine = s2 + s1.substring(cnt);
                    answer[i] = combine;
                }
            }
        }
        if(answer[1] != null){
            Arrays.sort(answer);
        }

        return answer[0];
    }

    public static int check(String s1, String s2) {
        int j = 1;
        int cnt = 0;
        for(int i = s1.length() - 1 ; i >= 0 ; i-- ){
            if(s1.substring(i).equals(s2.substring(0, j))){
                cnt = j;
            }
            if(j < minLength){
                j++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        System.out.println(solution("AxA", "AyA"));
        System.out.println(solution("xyZA", "ABCxyZE"));
        System.out.println(solution("ABCxyZE", "xyZA"));


    }
}
