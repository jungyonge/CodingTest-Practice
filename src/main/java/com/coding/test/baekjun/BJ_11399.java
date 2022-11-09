package com.coding.test.baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11399 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] arr = new int[cnt];
        int[] sum = new int[cnt + 1];
        for(int i =0; i<cnt;i++){
            arr[i] = scanner.nextInt();
        }


        Arrays.sort(arr);
        for(int i = 0 ; i< cnt; i++){
            if(i != 0){
                sum[i + 1] = sum[i] + arr[i];
            }else {
                sum[i + 1] = arr[i];
            }
        }

        System.out.println(Arrays.stream(sum).sum());

    }
}
