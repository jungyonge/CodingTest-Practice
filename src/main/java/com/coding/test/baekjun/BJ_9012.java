package com.coding.test.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st;

        int cnt = Integer.parseInt(br.readLine());


        for(int i = 0 ; i < cnt; i ++){
            boolean check = true;
            Stack<String> stack = new Stack<>();
            String[] test = br.readLine().split("");
            for(String s : test){
                if(s.equals("(")){
                    stack.push(s);
                }else {
                    if(stack.isEmpty()){
                        check = false;
                        break;
                    }else {
                        stack.pop();
                    }
                }
            }
            if(!check){
                System.out.println("NO");
            }else if(!stack.isEmpty()){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }

    }

}
