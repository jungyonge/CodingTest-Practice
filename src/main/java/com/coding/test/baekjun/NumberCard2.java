package com.coding.test.baekjun;

import java.util.HashMap;
import java.util.Scanner;

public class NumberCard2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < cnt ; i++){
            int number = scanner.nextInt();
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        cnt = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < cnt ; i++){
            int number = scanner.nextInt();
            sb.append(map.getOrDefault(number,0)).append(" ");
        }

        System.out.println(sb);
    }
}
