package com.coding.test.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Ex_14 {

    public static int solution(int[] citations) {
            int[] sorted = Arrays.stream(citations).sorted().toArray();
            int answer = 0;
            for(int i=sorted.length-1; i>=0; i--){
                if(sorted[i] > answer){
                    answer++;
                }else{
                    break;
                }
            }
            return answer;
        }


    public static void main(String[] args) {
//        int[] cita = {3,0,6,1,5};
        int[] cita = {3,5,1,2};
        solution(cita);
    }
}
