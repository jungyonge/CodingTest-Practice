package com.coding.test.baekjun;

import java.util.Scanner;

public class OverAvg {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        for(int i = 0 ; i < cnt ; i ++){
            double subCnt = scanner.nextInt();
            double overAvg = 0;
            double sumScore = 0;
            int[] subScore = new int[(int) subCnt];
            for(int j = 0 ; j < subCnt ; j ++){
                subScore[j] = scanner.nextInt();
                sumScore += subScore[j];
            }
            double avgScore = sumScore / subCnt;
            for(int score : subScore){
                if(score > avgScore){
                    overAvg++;
                }
            }

            System.out.printf("%.3f%%\n",(Math.round(((overAvg / subCnt) * 100) * 1000) / 1000.0));
        }

    }
}
