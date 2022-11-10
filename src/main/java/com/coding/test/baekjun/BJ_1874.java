package com.coding.test.baekjun;

import java.util.Scanner;
import java.util.Stack;

public class BJ_1874 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] numArray = new int[cnt];
        String result = "";
        for (int i = 0; i < cnt; i++) {
            numArray[i] = scanner.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int pushNumber = 1;
        for (int i = 0; i < cnt; i++) {
            int target = numArray[i];
            while (true) {
                if (stack.isEmpty()) {
                    sb.append("+").append("\n");
                    stack.push(pushNumber);
                    pushNumber++;
                }else {
                    if (target == stack.peek()) {
                        sb.append("-").append("\n");
                        stack.pop();
                        break;
                    } else if (target < stack.peek()) {
                        result = "NO";
                        break;
                    } else {
                        sb.append("+").append("\n");
                        stack.push(pushNumber);
                        pushNumber++;
                    }
                }

            }
            if (result.equals("NO")) {
                break;
            }
        }

        if (result.equals("NO")) {
            System.out.println(result);
        }else {
            System.out.println(sb.toString());

        }

    }
}
