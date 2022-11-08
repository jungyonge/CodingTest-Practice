package com.coding.test.baekjun;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class BJ_2559 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCnt = scanner.nextInt();
        int gap = scanner.nextInt();
        int[] sumArr = new int[numberCnt - gap + 1];
        int[] numArr = new int[numberCnt];

        for(int i = 0 ; i< numberCnt; i++){
            numArr[i] = scanner.nextInt();
        }

        for(int i = 0 ; i < numberCnt - gap + 1; i++){
            int sum = 0;
            for(int j = i ; j < i + gap; j ++){
                sum = sum + numArr[j];
            }
            sumArr[i] = sum;
        }
        OptionalInt max = Arrays.stream(sumArr).max();
        System.out.println(max.getAsInt());
    }
}
