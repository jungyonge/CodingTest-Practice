package com.coding.test.codility;

import java.util.Arrays;

public class PermMissingElem {
    public int solution(int[] A) {
        // Implement your solution here

        int result = 0;

        Arrays.sort(A);
        if(A.length == 0){
            return 1;
        }

        boolean check = true;
        for(int i = 0 ; i < A.length - 1 ; i ++){
            if(A[i] - A[i + 1] != -1){
                result = A[i] + 1;
                check = false;
                break;
            }
        }
        if(check){
            if(A[0] != 1){
                result = 1;
            }else {
                result = A[A.length -1 ] + 1;
            }
        }
        return result;
    }

}
