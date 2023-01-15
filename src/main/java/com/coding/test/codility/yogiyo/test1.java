package com.coding.test.codility.yogiyo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class test1 {

    public static String[] alphabetArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static String solution(int N, int K) {
        // Implement your solution here
        String[] resultArray = new String[N];
        int k = K;
        int alphabetIndex = -1;
        if(N % 2 == 1){
            k--;
            alphabetIndex++;
            resultArray[N / 2] = alphabetArray[alphabetIndex];
        }
        int tail = 0 ;
        int head = N - 1;
        while (true) {
            if(k > 0){
                k--;
                alphabetIndex++;
            }
            resultArray[tail] = alphabetArray[alphabetIndex];
            resultArray[head] = alphabetArray[alphabetIndex];
            tail++;
            head--;
            if(tail >= head || tail >= N / 2){
                break;
            }
        }
        return String.join("", resultArray);
    }

    public static void main(String[] args) {
        System.out.println(solution(200,26));
    }
}
