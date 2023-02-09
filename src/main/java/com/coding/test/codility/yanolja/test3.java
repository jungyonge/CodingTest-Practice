package com.coding.test.codility.yanolja;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class test3 {

    public static int solution(int[] A) {
        // Implement your solution here
        TreeSet<Integer> set = new TreeSet<>();
        for(int a : A) {
            set.add(a);
        }

        SortedSet<Integer> middle ;
        System.out.println(set.size()/2);
        System.out.println(set.size()/2+1);

        middle = set.subSet(set.size() / 2 + 1,true , set.size() / 2 + 2,true );
        int mid = 0;
        if(middle.size()> 1){
            mid = middle.last();
        }else {
            mid = middle.first();
        }
        int sum = 0;
        for(int a : A) {
            if ( a != mid){
                sum = sum + Math.abs(mid - a);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,2,4,6}));
    }
}
