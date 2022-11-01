package com.coding.test.baekjun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CheckAlpha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstCnt = scanner.nextInt();
        int secCnt = scanner.nextInt();
        Set<String> orginSet = new HashSet<>();
        for(int i = 0 ; i < firstCnt ; i++){
            orginSet.add(scanner.next());
        }

        int sum= 0;
        for(int i = 0 ; i < secCnt ; i++){
            if(orginSet.contains(scanner.next())){
                sum++;
            }
        }

        System.out.println(sum);
    }
}
