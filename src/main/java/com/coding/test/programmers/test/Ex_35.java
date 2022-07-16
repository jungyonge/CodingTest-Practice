package com.coding.test.programmers.test;

import java.util.ArrayList;
import java.util.Collections;

public class Ex_35 {
    public static int[] solution(int[] numbers) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < numbers.length; i ++){
            for(int j = 0 ; j < numbers.length ; j++){
                if(i != j){
                    int number = numbers[i] + numbers[j];
                    if(!arr.contains(number)){
                        System.out.println(number);
                        arr.add(number);
                    }
                }
            }
        }
        Collections.sort(arr);
        int[] answer = arr.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    public static void main(String[] args) {
        int[] num = {2,1,3,4,1};
        solution(num);
    }
}
