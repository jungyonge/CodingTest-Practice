package com.coding.test.baekjun;

import java.util.Scanner;

public class BJ_14888 {

    static int MAX = Integer.MIN_VALUE ;
    static int MIN = Integer.MAX_VALUE ;
    static int cnt = 0;
    static int[] numArr;
    static int[] command;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cnt = scanner.nextInt();
        numArr = new int[cnt];
        command = new int[4];
        for(int i = 0 ; i < cnt ; i ++){
            numArr[i] = scanner.nextInt();
        }
        for(int i = 0 ; i < 4 ; i ++){
            command[i] = scanner.nextInt();
        }

        dfs(numArr[0], 0 );
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int now , int depth){

        if(depth == cnt - 1){
            MAX = Math.max(now,MAX);
            MIN = Math.min(now,MIN);
            return;
        }

        for (int i = 0 ; i < 4 ; i ++){

            if(command[i] > 0){

                command[i]--;
                switch(i) {

                    case 0:

                        dfs(now + numArr[depth + 1], depth + 1);
                        break;
                    case 1:
                        dfs(now - numArr[depth + 1], depth + 1);
                        break;
                    case 2:
                        dfs(now * numArr[depth + 1], depth + 1);
                        break;
                    case 3:
                        dfs(now / numArr[depth + 1], depth + 1);
                        break;
                }
                command[i]++;

            }
        }
    }
}
