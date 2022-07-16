package com.coding.test.programmers.test;

import java.util.Arrays;
import java.util.Comparator;

public class Ex_13 {
    public static String solution(int[] numbers) {
        String answer = "";

        String[] sNumbers = new String[numbers.length];

        for(int i=0; i<numbers.length; i++){
            sNumbers[i] = numbers[i] + "";
        }

        Arrays.sort(sNumbers, new Comparator<String>(){
            @Override
            public int compare(String n1, String n2){
                // 더해서 큰 값 만드는 내림 차순
                return (n2+n1).compareTo(n1+n2);
            }
        });

        for(int i=0; i<sNumbers.length; i++){
            answer += sNumbers[i];
        }

        // "000" 과 같이 0이 여러번인 경우 제외
        if(answer.startsWith("0"))
            answer = "0";

        return answer;
    }

    public static void main(String[] args) {
        int[] num = {6, 10, 2};
        solution(num);
    }
}
