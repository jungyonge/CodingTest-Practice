package com.coding.test.baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {
        int[] origin = {1,1,2,2,2,8};

        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < origin.length ; i ++){
            sb.append(origin[i] - scanner.nextInt()).append(" ");
        }

        System.out.println(sb);
    }
}
