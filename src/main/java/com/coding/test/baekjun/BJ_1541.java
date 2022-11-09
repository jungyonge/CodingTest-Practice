package com.coding.test.baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BJ_1541 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("");
        Queue<String> itemQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int sum = 0;
        boolean check = false;
        boolean check2 = false;
        for(String s : line){
            if(isNumeric(s)){
                sb.append(s);
            }else {
                if(s.toString().equals("+")){
                    check = true;
                }
                itemQueue.add(sb.toString());
                sb = new StringBuilder();
                itemQueue.add(s);
            }
        }
        itemQueue.add(sb.toString());


        if(check){
            while (!itemQueue.isEmpty()){
                String temp = itemQueue.poll();
                if(isNumeric(temp)){
                    stack.push(temp);
                }else if(temp.equals("+")) {
                    stack.push(String.valueOf(
                            Integer.parseInt(stack.pop()) + Integer.parseInt(itemQueue.poll())));
                }
            }

            for(int i = 0 ; i < stack.size(); i ++){
                if(i == 0 ){
                    sum = Integer.parseInt(stack.get(i));
                }else {
                    sum -= Integer.parseInt(stack.get(i));
                }
            }
            System.out.println(sum);
        }else {
            sum = Integer.parseInt(itemQueue.poll());
            while (!itemQueue.isEmpty()){
                String temp = itemQueue.poll();
                if(isNumeric(temp)) {
                    sum -= Integer.parseInt(temp);
                }
            }

            System.out.println(sum);
        }


    }

    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
}
