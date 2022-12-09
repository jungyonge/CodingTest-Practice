package com.coding.test.baekjun;

import java.util.Scanner;

public class BJ_1629 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        double result = Math.pow(Integer.parseInt(line[0]), Integer.parseInt(line[1])); //5의제곱
        double div = (result % Integer.parseInt(line[2]));
        System.out.println(div);
    }

}
