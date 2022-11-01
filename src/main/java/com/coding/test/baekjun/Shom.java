package com.coding.test.baekjun;

import java.util.Scanner;

public class Shom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int front = 0;
        int back = 0;
        String middle = "666";
        int result = 0;

        for(int i = 0 ; i < cnt ; i++){
            String frontWord = front + middle;
            String backWord = middle + back;
            System.out.println(i + " " + frontWord + " " + backWord);
            if(Integer.parseInt(frontWord) < Integer.parseInt(backWord)){
                result = Integer.parseInt(frontWord);
                front++;
            }else {
                result = Integer.parseInt(backWord);
                back++;
            }

        }

        System.out.println(result);


    }
}
