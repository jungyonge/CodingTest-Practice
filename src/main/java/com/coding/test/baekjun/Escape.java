package com.coding.test.baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Escape {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int maxX = scanner.nextInt();
        int maxY = scanner.nextInt();
        int[] result = new int[4];
        result[0] = maxX - X;
        result[1] = maxY - Y;
        result[2] = X - 0;
        result[3] = Y - 0;
        Arrays.sort(result);
        System.out.println(result[0]);
    }
}
