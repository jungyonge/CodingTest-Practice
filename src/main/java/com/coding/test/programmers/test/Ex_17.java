package com.coding.test.programmers.test;

import javax.swing.*;
import java.util.Arrays;

public class Ex_17 {
    static int i = 0;
    static int result = 0;

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }

    private static int dfs(int[] numbers, int node, int sum, int target){
        print(numbers,  node,  sum,  target);
        if(node == numbers.length){
            if(sum==target)
                return 1;
            return 0;
        }
        result = dfs(numbers, node+1, sum + numbers[node], target) + dfs(numbers, node+1, sum - numbers[node], target);;

        return result;
    }
    private static void print(int[] numbers, int node, int sum, int target) {
        System.out.println(i++);
        System.out.println("number : " + Arrays.toString(numbers));
        System.out.println("node : " + node);
        System.out.println("sum : " + sum);
        System.out.println("target : " + target);

    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        int ans = solution(numbers,target);

        System.out.println(ans);
        //https://lkhlkh23.tistory.com/74
    }
}
