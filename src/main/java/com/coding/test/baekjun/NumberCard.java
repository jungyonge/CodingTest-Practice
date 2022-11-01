package com.coding.test.baekjun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberCard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstDeck = new HashSet<>();
        Set<Integer> secondDeck = new HashSet<>();

        int firstCount = scanner.nextInt();
        for(int i = 0; i < firstCount; i ++){
            firstDeck.add(scanner.nextInt());
        }

        int secondCount = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < secondCount; i ++){
            if(firstDeck.contains(scanner.nextInt())){
                sb.append(1).append(" ");
            }else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
