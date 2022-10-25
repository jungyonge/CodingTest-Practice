package com.coding.test.baekjun;

import java.util.Scanner;

public class Alram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int min = scanner.nextInt();
        int needCookMin = scanner.nextInt();
        int resetMin = min + needCookMin;
        hour = hour + (resetMin / 60);
        if(hour >= 24){
            hour = hour - 24;
        }
        resetMin = resetMin % 60;
        System.out.println(hour + " " + resetMin);
    }
}
