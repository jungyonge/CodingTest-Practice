package com.coding.test.baekjun;

import java.util.Scanner;

public class Joonas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int sec = scanner.nextInt();
        int third = scanner.nextInt();
        System.out.println((first + sec) % third );
        System.out.println(((first%third) + (sec%third))%third);
        System.out.println((first * sec)%third);
        System.out.println( ((first%third) * (sec%third))%third);
    }
}
