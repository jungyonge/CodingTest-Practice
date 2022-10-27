package com.coding.test.baekjun;

import java.util.LinkedList;

public class Dn {

    public static void main(String[] args) {
        boolean[] check = new boolean[100001];
        for(int i = 1 ; i < 10001 ; i++){
            if(check[i]){
                continue;
            }
            int dN = i;
            while (true){
                int sum = rec(dN);
                dN += sum;
                check[dN] = true;
                if(dN >= 10000){
                    break;
                }
            }
        }

        for(int i = 1 ; i <10001; i++){
            if(!check[i]){
                System.out.println(i);
            }
        }
    }

    public static int rec(int i){

        LinkedList<Integer> stack = new LinkedList<Integer>();
        int sum = 0;
        while(i > 0){
            stack.push(i % 10);
            i = i / 10;
        }
        while ((!stack.isEmpty())){
            sum += stack.poll();
        }
        return sum;
    }
}
