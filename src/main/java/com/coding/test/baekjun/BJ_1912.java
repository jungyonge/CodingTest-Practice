package com.coding.test.baekjun;

import java.util.Scanner;

public class BJ_1912 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] numArr = new int[cnt];
        for(int i = 0 ; i < cnt ; i++){
            numArr[i] = scanner.nextInt();
        }
        int max = -99999999;

        for(int i = 0 ; i < cnt ; i++){
            for(int ij = 0 ; ij < cnt ; ij++) {
                int sum = 0;
                for(int j = ij ; j < ij + i + 1; j++ ){
                    if(j > numArr.length - 1){
                        continue;
                    }
                    sum = sum + numArr[j];
                }
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
    }

}
