package com.coding.test.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Ex_32 {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        ArrayList<Integer> integerArray = (ArrayList<Integer>) Arrays.stream(d).boxed().collect(Collectors.toList());
        Collections.sort(integerArray);
        for(Integer bud : integerArray){

            budget -= bud;
            if(budget < 0){
                return answer;
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int bug = 9;
        solution(d,bug);
    }
}
