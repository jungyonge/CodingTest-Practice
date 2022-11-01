package com.coding.test.baekjun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DIffAlpha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        String alpha = scanner.next();
        int cnt = alpha.length();
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < cnt ; i++){
            for(int j = 1; j < cnt + 1 ; j++){
                if(i > j){
                    continue;
                }
                String temp = alpha.substring(i,j);
                set.add(temp);
            }
        }

        System.out.println(set.size() - 1);

    }

    public static void find(Set<String > set){

    }
}
