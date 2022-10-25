package com.coding.test.baekjun;

import java.util.Scanner;

public class Mul {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        String secStr = scanner.next();
        String[] sec = secStr.split("");


        for(int i = sec.length - 1; i >= 0 ; i--){
            System.out.println(first * Integer.parseInt(sec[i]));
        }
        System.out.println(first * Integer.parseInt(secStr));
    }
}
