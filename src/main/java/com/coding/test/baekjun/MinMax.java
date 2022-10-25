package com.coding.test.baekjun;

import java.util.Scanner;

public class MinMax {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        int min = 1000000;
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            int num = scanner.nextInt();
            if(num < min){
                min = num;
            }
            if(num > max){
                max = num;
            }
        }
        System.out.println(min + " " + max);

    }
}
