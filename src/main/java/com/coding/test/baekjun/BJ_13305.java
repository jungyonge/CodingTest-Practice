package com.coding.test.baekjun;

import java.util.Scanner;

public class BJ_13305 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long cnt = scanner.nextInt();
        long[] distance = new long[(int) (cnt - 1)];
        long[] gasFee = new long[(int) cnt];
        long sum = 0;

        for(int i = 0 ; i < cnt - 1; i ++ ){
            distance[i] = scanner.nextInt();
        }

        for(int i = 0 ; i < cnt ; i ++ ){
            gasFee[i] = scanner.nextInt();
        }
        long minCost = gasFee[0];	// 이전 까지의 과정 중 주유 최소 비용

        for(int i = 0; i < cnt - 1; i++) {

            /*
             *  현재 주유소가 이전 주유소의 기름값보다 쌀 경우
             *  minCost를 갱신해준다.
             */
            if(gasFee[i] < minCost) {
                minCost = gasFee[i];
            }

            sum += (minCost * distance[i]);	// 총 비용 누적 합
        }

        System.out.println(sum);
    }
}
