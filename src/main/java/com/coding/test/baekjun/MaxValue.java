package com.coding.test.baekjun;

import java.util.Scanner;

public class MaxValue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxNum = 0;
        int maxWhere = 0;
        int count = 0;

        while (true){
            if(!scanner.hasNext()){
                break;
            }
            count++;
            int target = scanner.nextInt();
            if(maxNum < target){
                maxNum = target;
                maxWhere = count;
            }
        }
        System.out.println(maxNum);
        System.out.println(maxWhere);

    }
}
