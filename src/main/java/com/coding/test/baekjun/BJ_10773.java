package com.coding.test.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < cnt ; i ++){
            int temp = Integer.parseInt(br.readLine());
            if(temp != 0){
                stack.push(temp);
            }else {
                stack.pop();
            }
        }

        int sum = 0;
        while (!stack.isEmpty()){

        sum += stack.pop();
        }
        System.out.println(sum);
    }
}
