package com.coding.test.baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1931 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        String[] time = new String[cnt];
        scanner.nextLine();
        for(int i =  0; i < cnt ; i++){
            time[i] = scanner.nextLine();
        }
        Arrays.sort(time);
        System.out.println(time);
    }

    public static void dfs()
}
