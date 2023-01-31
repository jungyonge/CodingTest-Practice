package com.coding.test.programmers.celeb;

public class test1
{

    static int MAX = 0;
    public static int solution(int[] estimates, int k) {


        int[] prefix_sum = new int[estimates.length];
        prefix_sum[0] = estimates[0];
        MAX = prefix_sum[0];

        for(int i = 1 ; i < estimates.length ; i ++){
            prefix_sum[i] = prefix_sum[i - 1] + estimates[i];
        }

        if(k == estimates.length){
            return prefix_sum[estimates.length - 1];
        }
        for(int i = k ; i < estimates.length; i ++){
            MAX = Math.max(MAX , prefix_sum[i] - prefix_sum[i - k]);
        }
        MAX = Math.max(MAX , prefix_sum[k - 1]);


        return MAX;

//        for(i=0; i<n-k+1; i++){
//
//            for(m=k-1; m>=0; m--){
//                dummy = dummy + estimates[i+k-m-1];
//            }
//
//            MAX = Math.max(MAX, dummy);
//            dummy = 0;
//        }
    }
//
    public static void main(String[] args) {

        System.out.println(solution(new int[]{111,11,11,12}, 3));
    }


}
