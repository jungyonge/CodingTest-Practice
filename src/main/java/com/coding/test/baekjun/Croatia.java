package com.coding.test.baekjun;

import java.util.Scanner;

public class Croatia {

    public static void main(String[] args) {
        String[] alphabet = {
                "c=",
                "c-",
                "dz=",
                "d-",
                "lj",
                "nj",
                "s=",
                "z="};

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int sum = 0;
        for(String temp : alphabet){
            str = str.replaceAll(temp,"1");
        }
        System.out.println(str.split("").length);
    }
}
