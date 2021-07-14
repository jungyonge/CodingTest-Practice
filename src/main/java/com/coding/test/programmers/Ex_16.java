package com.coding.test.programmers;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ex_16 {
    public static int solution(String numbers) {
        int answer = 0;
        ArrayList<String> num_list = new ArrayList<>();
        ArrayList<String> num_list2 = new ArrayList<>();

        for(int i = 0 ; i < numbers.length() ; i ++){
            num_list.add(String.valueOf(numbers.charAt(i)));
        }

        System.out.println(num_list);
        return answer;
    }

    public static void main(String[] args) {
        solution("123");
    }
}
