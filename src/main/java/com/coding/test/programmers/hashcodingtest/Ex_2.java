package com.coding.test.programmers.hashcodingtest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex_2 {
//    https://school.programmers.co.kr/learn/courses/30/lessons/42577
//    전화번호 목록

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        int count = 0;
        List<String> tempPhoneBook1 = Arrays.asList(phone_book);
        List<String> tempPhoneBook2 = Arrays.asList(phone_book);


        for(int i = 0 ; i < phone_book.length; i++){
            for(int j = 0 ; j < phone_book.length; j++){
                if( i == j ){
                    continue;
                }
                if(tempPhoneBook1.get(i).startsWith(tempPhoneBook2.get(j))){
                    answer = false;
                    break;
                }
            }
        }

        if(count != 0){
            answer = false;
        }
        return answer;
    }

    public static void main(String[] args) {

        solution(new String[]{"119", "97674223", "1195524421"});
    }
}
