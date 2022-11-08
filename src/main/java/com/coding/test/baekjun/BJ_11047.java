package com.coding.test.baekjun;

import java.util.Scanner;

public class BJ_11047 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coinCount = scanner.nextInt();
        int goal = scanner.nextInt();
        int[] coin = new int[coinCount];
        int sum = 0;

        for(int i = 0 ; i < coinCount; i ++){
            coin[i] = scanner.nextInt();
        }

        for(int i = coinCount - 1 ; i >= 0; i --){
            if(goal == 0){
                break;
            }

            while (true){
                if(coin[i] <= goal){
                    goal = goal - coin[i];
                    sum++;
                }else {
                    break;
                }
            }

        }

        System.out.println(sum);
    }
}
