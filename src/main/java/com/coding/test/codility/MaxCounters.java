package com.coding.test.codility;

import java.util.Arrays;

public class MaxCounters {

    public static int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int max = 0;
        boolean change_max = false;
        for(int num : A){
            if(num <= N && num >= 1){
                result[num - 1] = result[num- 1] + 1;
                if(max < result[num - 1] ){
                    max = Math.max(max, result[num - 1]);
                    change_max = true;
                }
            }
            if(num ==  N + 1 && change_max){
                change_max = false;
                Arrays.fill(result, max);
            }
        }
        return result;
    }


    public static void main(String[] args) {

        System.out.println(solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
    }
}
