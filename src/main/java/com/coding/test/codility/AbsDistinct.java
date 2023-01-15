package com.coding.test.codility;

import java.util.HashSet;
import java.util.Set;

public class AbsDistinct {

    public static int solution(int[] A) {
        // Implement your solution here
        Set<Integer> set = new HashSet<>();
        for(int number : A){
            set.add(Math.abs(number));
        }
        return set.size();
    }
    public static void main(String[] args) {

        System.out.println(solution(new int[]{-5,-3,-1,0,3,6}));

    }
}
