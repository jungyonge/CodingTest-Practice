package com.coding.test.baekjun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountDiff {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> check = new HashSet<>();

        while (true){
            if(!scanner.hasNext()){
                break;
            }
            int targetNum = scanner.nextInt() % 42;
            check.add(targetNum);
        }

        System.out.println(check.size());
    }
}
