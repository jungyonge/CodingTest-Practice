package com.coding.test.baekjun;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Difference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        scanner.nextLine();
        String[] firstGr = scanner.nextLine().split(" ");
        Set<String> firstGroup = Arrays.stream(firstGr).collect(Collectors.toSet());
        String[] secondGr = scanner.nextLine().split(" ");
        Set<String> secondGroup = Arrays.stream(secondGr).collect(Collectors.toSet());
        int sum = 0;
        for(int i = 0 ; i < first ; i++){
            if(!secondGroup.contains(firstGr[i])){
                sum++;
            }
        }

        for(int i = 0 ; i < second ; i++){
            if(!firstGroup.contains(secondGr[i])){
                sum++;
            }
        }

        System.out.println(sum);
    }
}
