package com.coding.test.baekjun;

import java.util.LinkedList;
import java.util.Scanner;

public class Hansu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = 0;
        boolean[] checkHansu = new boolean[num];

        for(int i = 1 ; i < num+1; i++){
            boolean res = rec(i);
            if(res){
                sum++;
            }
        }

        System.out.println(sum);
    }

    public static boolean rec(int i){

        boolean check = true;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int sum = 0;
        while(i > 0){
            stack.push(i % 10);
            i = i / 10;
        }
        int firstNum = stack.pop();
        if(stack.isEmpty()){
            return true;
        }
        int secNum = stack.pop();
        int gap = firstNum - secNum;

        while (!stack.isEmpty()){
            int temp = stack.pop();
            firstNum = secNum;
            secNum = temp;
            if(firstNum - secNum != gap){
                return false;
            }
        }
        return check;
    }
}
