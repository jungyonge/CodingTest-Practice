package com.coding.test.baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11659 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cnt = scanner.nextInt();
        int line = scanner.nextInt();
        int[] numArr = new int[cnt];
        int[] sumArr = new int[cnt + 1];
        sumArr[0] = 0;
        for(int i = 0 ; i< cnt; i++){
            numArr[i] = scanner.nextInt();
            if(i != 0){
                sumArr[i + 1] = sumArr[i] + numArr[i];
            }else {
                sumArr[i + 1] = numArr[i];

            }
        }

        for(int i = 0 ; i < line; i++){
            int start = scanner.nextInt();
            int last = scanner.nextInt();
            int sum = 0;
            int res = sumArr[last] - sumArr[start - 1];
            System.out.println(res);
        }
    }
}
