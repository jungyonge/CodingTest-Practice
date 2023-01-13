package com.coding.test.codility;

import com.coding.test.stack.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        int[] arr = new int[A.length];

        for (int i = 0; i < A.length; i++)
            arr[(i + K) % A.length] = A[i];

        return arr;
    }

//    public static void main(String[] args) {
//
//        solution(new int[]{3, 8, 9, 7, 6}, 15 );
//    }

}
