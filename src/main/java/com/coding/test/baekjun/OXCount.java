package com.coding.test.baekjun;

import java.util.Scanner;

public class OXCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();

        String[] answer ;

        for(int i = 0 ; i < cnt ; i++){
            int sumPoint = 0;
            answer = scanner.next().split("");
            int point = 0;
            for(String ans : answer){
                if(ans.equals("O")){
                    point++;
                    sumPoint = sumPoint + point;

                }else {
                    point = 0;
                }
            }
            System.out.println(sumPoint);

        }

    }
}
