package com.coding.test.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    stack.push(Integer.valueOf(command[1]));
                    break;
                case "top":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    }else {
                        System.out.println(stack.peek());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        System.out.println(1);
                    }else {
                        System.out.println(0);
                    }
                    break;
                case "pop":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    }else {
                        System.out.println(stack.pop());
                    }
                    break;

            }
        }


    }
}
