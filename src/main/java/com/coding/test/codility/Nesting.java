package com.coding.test.codility;

import java.util.Stack;

public class Nesting {

    public static int solution(String S) {
        int result = 0 ;
        char tt = '악';
        Stack<Character >stack = new Stack<>();
        char bracket;

        for (int i = 0; i < S.length(); i++) {
            bracket = S.charAt(i);
            if(stack.isEmpty() && bracket == ')'){
                return 0;
            }
            if(bracket == '('){
                stack.push(bracket);
            }
            if(bracket == ')'){
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return 1;
        }else {
            return 0;
        }

        // Implement your solution here
    }

    public static void main(String[] args) {
        System.out.println(solution("(()(())())"));
    }
}
