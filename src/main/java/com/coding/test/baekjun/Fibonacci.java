package com.coding.test.baekjun;

public class Fibonacci {

    //재귀
    //피보나치
    //https://www.acmicpc.net/problem/10870
    //https://st-lab.tistory.com/94
    public static void main(String[] args) {
        fibonacci(10);
        System.out.println(fibonacci(10));
    }

    public static int fibonacci(int i ){
        System.out.println(i);
        if(i == 1){
            return 1;
        }
        if(i == 0){
            return 0;
        }
        return fibonacci(i - 1) + fibonacci(i -2);
    }
}
