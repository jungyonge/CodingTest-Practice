package com.coding.test.baekjun;

public class SumN {

    public long sum(int[] a){
        int sum = 0;
        for(int i : a){
            sum += i;
        }
        return sum;
    }
}
