package com.coding.test.baekjun;

import java.util.Scanner;

public class MaxWhere {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxNum = -1;
        String position = "";
        for(int i = 1 ; i < 10; i ++){
            for(int j = 1 ; j < 10; j ++){
                int targetNum = scanner.nextInt();
                if(maxNum < targetNum){
                    maxNum = targetNum;
                    position = i + " " + j;
                }
            }

        }
        System.out.println(maxNum);
        System.out.println(position);
    }
}
