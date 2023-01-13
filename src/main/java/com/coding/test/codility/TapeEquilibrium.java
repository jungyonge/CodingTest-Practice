package com.coding.test.codility;

public class TapeEquilibrium {

    public static int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        int[] prefix_sum = new int[A.length];
        prefix_sum[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            prefix_sum[i] = A[i] + prefix_sum[i - 1];
        }

        for (int i = 0; i < prefix_sum.length - 1; i++) {
            int temp = Math.abs((prefix_sum[prefix_sum.length - 1] - prefix_sum[i]) - prefix_sum[i]);
            min = Math.min(temp, min);
        }
        return min;
        // Implement your solution here
    }

    public static void main(String[] args) {
        solution(new int[]{3,1,2,4,3});
    }
}
