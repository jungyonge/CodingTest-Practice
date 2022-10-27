package com.coding.test.baekjun;

import java.util.Scanner;

public class Climb {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int up = scanner.nextInt();
        int down = scanner.nextInt();
        int stick = scanner.nextInt();
        int climb = 0;
        int day = 0;

        while (true){
            day++;
            climb += up;
            if(climb >= stick){
                break;
            }
            climb -= down;
        }
        System.out.println(day);
    }
}
