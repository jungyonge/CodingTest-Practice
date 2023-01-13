package com.coding.test.codility;

import java.util.Arrays;

public class MissingInteger {

    public static int solution(int[] A) {
        // Implement your solution here
        int result = 0;

        Arrays.sort(A);
        if(A[A.length - 1] < 0){
            return 1;
        }
        boolean[] visited = new boolean[A[A.length - 1] + 1];
        for(int num : A){
            if(num > 0){
                visited[num] = true;
            }
        }

        for(int i = 1 ; i < visited.length; i ++) {
            if (!visited[i]) {
                result = i ;
                break;
            }
        }

        if(result == 0){
            result = A[A.length - 1] + 1;
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,6,4,1,2}));
        System.out.println(solution(new int[]{-1,-3}));
        System.out.println(solution(new int[]{1,2,3}));

    }
}
