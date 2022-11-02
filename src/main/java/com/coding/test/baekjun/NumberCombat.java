package com.coding.test.baekjun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberCombat {

    private static void reculsion(List<String> arr, List<String> temp, List<String> result, int n, int r) {


        if (r == 0) {

            result.add(temp.toString());
            return ;
        }

        for (int i = 0; i < n; i++) {
            temp.add(arr.remove(i));
            reculsion(arr, temp, result, n - 1, r - 1);
            arr.add(i, temp.remove(temp.size() - 1));
        }

    }

    public static int factorial(int number) {
        if(number == 1)
            return 1;
        else
            return number * factorial(number-1);
    }

    public static int Function(int num)
    {
        if(num == 1)
        {
            return 1;
        }
        else
        {
            return num + Function(num -1);
        }
    }
//    public static void main(String[] args) {
//
////        System.out.println("10팩토리얼은"+factorial(5));
//
////        System.out.println(Function(5));
////
////
//        List<String> arr = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        int cnt2 = scanner.nextInt();
//        for(int i = 0; i < cnt ; i ++){
//            arr.add(String.valueOf(i + 1));
//        }
//
//
//        List<String> temp = new ArrayList<>();
//        List<String> result = new ArrayList<>();
//
//        reculsion(arr, temp, result, arr.size(), cnt2);
//        Collections.sort(result);
//        for(String s : result){
//            System.out.println(s.replace("[","").replace("]","").replace(",",""));
//        }
//    }


    public static int[] arr;
    public static boolean[] visit;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);

    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }

}