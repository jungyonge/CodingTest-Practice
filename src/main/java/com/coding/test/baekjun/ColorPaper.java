package com.coding.test.baekjun;

import java.util.Scanner;

public class ColorPaper {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean[][] whitePaper = new boolean[100][100];
        int count =0;
        int cntPaper = scanner.nextInt();
        for(int i = 0 ; i < cntPaper ; i++){
            int paperX = scanner.nextInt();
            int paperY = scanner.nextInt();
            for(int x = paperX ; x < paperX + 10; x++){
                for(int y = paperY ; y < paperY + 10; y++){
                    if(!whitePaper[x][y]){
                        whitePaper[x][y] = true;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
