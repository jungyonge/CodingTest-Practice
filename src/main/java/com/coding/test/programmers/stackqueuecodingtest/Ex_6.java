package com.coding.test.programmers.stackqueuecodingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Ex_6 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/12909
//    올바른 괄호



    static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')  // 현재 (가 들어갈 자리면 스택에 넣는다.
                stack.push('(');
            else{
                if(stack.isEmpty()) // 현재 )가 들어갈 자리인데 스택이 비어있을경우 -> false
                    return false;
                else
                    stack.pop();    // 현재 )가 들어갈 상태에서 스택에 괄호('(')가 있는경우 -> pop
            }
        }
        answer = (stack.isEmpty()) ? true : false;
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution("()))((()"));
    }
}
