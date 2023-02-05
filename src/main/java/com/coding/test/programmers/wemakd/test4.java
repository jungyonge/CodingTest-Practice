package com.coding.test.programmers.wemakd;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class test4 {

    static boolean[] answer;

    public static boolean[] sol(String[] a) {
        answer = new boolean[a.length];

        for(int i = 0 ; i < a.length ; i++){
            String[] arr = a[i].split("");
            Deque<String> arrayDeque = Arrays.stream(arr)
                .collect(Collectors.toCollection(ArrayDeque::new));
            check(arrayDeque, i);
        }

        return answer;
    }

    public static void check (Deque<String> deque, int index){


        while (true){
            if(deque.size() == 1 && deque.getFirst().equals("a")){
                answer[index] = true;
                break;
            }
            if(deque.isEmpty()){
                break;
            }
            if(deque.getFirst().equals("a")){
                deque.pollFirst();
            }else if (deque.getLast().equals("a")){
                deque.pollLast();

            }else if (deque.size() > 1 && deque.getFirst().equals("b") && deque.getLast().equals("b")){
                deque.pollFirst();
                deque.pollLast();
            }else {
                break;
            }

        }
    }


    public static void main(String[] args) {

        System.out.println(sol(new String[]{"abab", "bbaa", "bababa", "bbbabababbbaa"}));
//        System.out.println(sol(new String[]{ "bbbabababbbaa"}));

    }
}
