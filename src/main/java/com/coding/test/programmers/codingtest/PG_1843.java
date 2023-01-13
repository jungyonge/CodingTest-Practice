package com.coding.test.programmers.codingtest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PG_1843 {
    static Integer dp[][];
    static int max;
    public static boolean[] visit;
    public static int[] array;
    public static List<Integer> stackToList;
    public static int solution(String arr[]) {
        int answer = 0;

        max = 0;
        Queue<String> itemQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int sum = 0;
        boolean check = false;
        for(String s : arr){
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

        while (!itemQueue.isEmpty()){
            String temp = itemQueue.poll();
            if(isNumeric(temp)){
                stack.push(temp);
            }else if(temp.equals("+")) {
                stack.push(String.valueOf(
                        Integer.parseInt(stack.pop()) + Integer.parseInt(itemQueue.poll())));
            }
        }

        stackToList = new ArrayList(stack);

        visit = new boolean[stackToList.size()];
        array = new int[stackToList.size()];

        dfs(stackToList.size(),stackToList.size(),0);

        return  max;
    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            int sum = array[0];
            StringBuilder sb = new StringBuilder();
            sb.append(array[0] + " ");

            for(int i = 1 ; i < array.length ; i++){
                sum -= array[i];
                sb.append(array[i] + " ");
            }
            System.out.println(sb);
            System.out.println(sum);
            max = Math.max(max,sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                array[depth] = Integer.parseInt(String.valueOf(stackToList.get(i)));
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public static void main(String[] args) {
        solution(new String[] {"5", "-", "3", "+", "1", "+", "2", "-", "4"});
    }
}
