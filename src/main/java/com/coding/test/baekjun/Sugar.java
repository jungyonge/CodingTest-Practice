package com.coding.test.baekjun;

import java.util.Scanner;

public class Sugar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int kg = scanner.nextInt();
        int tempKg = kg;
        sum = sum + tempKg/5;
        tempKg = tempKg - (tempKg/5 * 5);
        if(tempKg != 0 && tempKg%3 != 0){
            sum = -1;
        }else if (tempKg != 0 && tempKg%3 == 0){
            sum = sum + tempKg/3;
        }

        if(sum == -1){
            sum = 0;
            tempKg = kg;

            sum = sum + tempKg/3;
            tempKg = tempKg - (tempKg/3 * 3);
            if(tempKg != 0 && tempKg%5 != 0){
                sum = -1;
            }else if (tempKg != 0 && tempKg%5 == 0){
                sum = sum + tempKg/5;
            }
        }

        System.out.println(sum);
    }
}
