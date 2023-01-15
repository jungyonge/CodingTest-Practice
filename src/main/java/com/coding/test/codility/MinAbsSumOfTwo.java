package com.coding.test.codility;

import java.util.HashSet;

public class MinAbsSumOfTwo {
    public static int[] arr = new int[2];
    public static int arrLength;

    public static int min = Integer.MAX_VALUE;

    public static int solution(int[] A) {
        arrLength = A.length;
        // Implement your solution here
        HashSet<Integer> set = new HashSet<>();
        for(int num : A){
            set.add(num);
        }
        Integer[] arr = set.toArray(new Integer[0]);
        dfs(0, arr);
        return min;
    }

    public static void dfs(int depth, Integer[] A) {
        // 깊이가 M이랑 같아지면 출력후 return
        if (depth == 2) {
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                sum = sum + arr[i];
            }
            min = Math.min(Math.abs(sum), min);
            return;
        }

        for (int i = 0; i < arrLength; i++) {
            arr[depth] = A[i];
            dfs(depth + 1, A);
        }
    }

    public static void main(String[] args) {

        System.out.println((solution(new int[]{-8,4,5,-10,3})));
    }
}
