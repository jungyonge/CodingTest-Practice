package com.coding.test.codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermCheck {

    public static int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 1; i <= A.length; i++) {

            if (A[i - 1] != i)
                return 0;
        }

        return 1;
    }


    public static void main(String[] args) {

        solution(new int[]{4,1,3,2});
    }
}
