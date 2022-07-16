package com.coding.test.programmers.test;

import java.util.Locale;

public class Ex_29 {
    public static String solution(String new_id) {
        String answer = "";
        String temp = "";
        answer = new_id.toLowerCase(Locale.ROOT);
        answer = answer.replaceAll("[^0-9a-zA-Z\\\\s._-]","");
        answer = answer.replaceAll("[.]+",".");
        answer = answer.replaceAll("^[.]|[.]$","");
        if(answer.length() == 0){
            answer = "a";
        }
        if(answer.length() > 15){
            answer = answer.substring(0,15);
            answer = answer.replaceAll("[.]$","");
        }
        while (true){
            temp = answer.substring(answer.length() -1 );
            if(answer.length() <= 2){
                answer = answer + temp;
            }
            if(answer.length() > 2){
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String new_id = "abcdefghijklmn.p";
        solution(new_id);
    }
}
