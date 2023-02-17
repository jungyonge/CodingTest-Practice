package com.coding.test.programmers.inka;

import java.util.ArrayDeque;
import java.util.Arrays;

public class test1 {

    public static boolean solution(int[] arrA, int[] arrB) {
        boolean answer = false;
        ArrayDeque<Integer> aDeque = new ArrayDeque<>();
        for(int i = 0 ; i < arrA.length; i ++){
            aDeque.add(arrA[i]);
        }

        for(int i = 0 ; i < arrA.length; i ++){
            aDeque.addFirst(aDeque.pollLast());
            int[] tempArr = aDeque.stream().mapToInt(Integer::intValue).toArray();
            if(Arrays.equals(tempArr, arrB)){
                answer = true;
                break;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        System.out.println(solution(new int[]{7,8,10}, new int[]{10,7,8}));
    }
}
