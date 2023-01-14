package com.coding.test.codility;

public class MaxSliceSum {
    public static int solution(int[] A) {
        // Implement your solution here
        int[] prefix_sum = new int[A.length];
        int max = A[0];
        int max_index = 0;
        prefix_sum[0] = A[0];
        for(int i = 1 ; i < A.length; i ++){
            prefix_sum[i] = Math.max(prefix_sum[i - 1] + A[i], A[i]);
            if(prefix_sum[i] > max){
                max = prefix_sum[i];
                max_index = i;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{-3,6,-6,4,0}));
    }
}
