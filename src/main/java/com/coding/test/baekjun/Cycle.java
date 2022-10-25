package com.coding.test.baekjun;

import java.util.Scanner;

public class Cycle {
//https://www.acmicpc.net/problem/1110
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String orginNum = scanner.nextLine();
        String compareNum = "";
        String firstNum = orginNum;
        int cnt = 0;
        String[] firstNumArr = new String[2];
        if(Integer.parseInt(orginNum) < 10){
            firstNumArr[0] = String.valueOf(0);
            firstNumArr[1] = orginNum;
        }else {
            firstNumArr = orginNum.split("");
        }
        String[] secondNumArr = new String[2];
        while (true){
            cnt++;
            int secNum = Integer.parseInt(firstNumArr[0])  + Integer.parseInt(firstNumArr[1]);
            secondNumArr = String.valueOf(secNum).split("");
            if(secNum > 9){
                firstNum = firstNumArr[1] + secondNumArr[1];
            }else {
                firstNum = firstNumArr[1] + secondNumArr[0];
            }
            if(Integer.parseInt(orginNum) == Integer.parseInt(firstNum)){
                break;
            } else {
                firstNumArr = firstNum.split("");
            }
        }
        System.out.println(cnt);
    }

}
