package com.coding.test.baekjun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PositionPress {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cnt = scanner.nextInt();
        Set<Integer> numSet = new HashSet<>();
        int[] numArr = new int[cnt];
        for(int i = 0 ; i < cnt ; i++){
            int num = scanner.nextInt();;
            numSet.add(num);
            numArr[i] = num;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : numArr){
            int sum = 0;
            for(Integer j : numSet){
                if(i >j){
                    sum++;
                }
            }
            sb.append(sum).append(" ");
        }
        System.out.println(sb.toString().substring(0,sb.toString().length() - 1));
    }
}
