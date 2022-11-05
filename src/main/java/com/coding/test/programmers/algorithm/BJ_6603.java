package com.coding.test.programmers.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_6603 {

    public static int N;
    public static boolean[] visited;
    public static Integer[] numArr;
    public static int[] tempArr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String[] temp = scanner.nextLine().split(" ");

            if(temp[0].equals("0")){
                break;
            }
            numArr = Arrays.stream(temp).map(Integer::parseInt).toArray(Integer[]::new);
            tempArr = new int[6];
            visited = new boolean[numArr[0]];
            N = numArr[0];
            dfs(0,0);
            System.out.println();

        }
    }

    public static void dfs(int start, int depth){
        if(6 == depth){
            for(int var : tempArr){
                System.out.print(var + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start ; i < N ; i++){
            if(!visited[i]){
                visited[i] = true;
                tempArr[depth] = numArr[i + 1];
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }


    }
}
