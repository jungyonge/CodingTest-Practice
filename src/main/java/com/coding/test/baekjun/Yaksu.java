package com.coding.test.baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Yaksu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] numArray = new int[cnt];
        for(int i = 0 ; i < cnt ; i++){
            numArray[i] = scanner.nextInt();
        }
        Arrays.sort(numArray);
        System.out.println(numArray[0] * numArray[cnt - 1]);

    }

}
