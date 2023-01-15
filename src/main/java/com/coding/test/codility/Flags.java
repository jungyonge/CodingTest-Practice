package com.coding.test.codility;

import java.util.ArrayList;
import java.util.List;

public class Flags {

//    public static int solution(int[] A) {
//        // Implement your solution here
//        int result = 0;
//        boolean[] peek = new boolean[A.length];
//        List<Integer> peek_index = new ArrayList<>();
//        int temp_peek = 0;
//        if(A[0] > A[1]){
//            peek[0] = true;
//            peek_index.add(0);
//
//        }
//        if(A[A.length - 1] > A[A.length - 2]){
//            peek[A.length - 1] = true;
//            peek_index.add(A.length - 1);
//        }
//        for(int i = 1 ; i < A.length -1 ; i ++){
//            if(A[i] > A[i - 1] && A[i] > A[i + 1]){
//                peek[i] = true;
//                peek_index.add(i);
//            }
//        }
//        int max_cnt = 0;
//        for(int i = 2 ; i < peek_index.size() + 1; i ++){
//            int cnt = i;
//            for(int j = 0 ; j < peek_index.size() - 1; j ++){
//                if(peek_index.get(j + 1) - peek_index.get(j) >= i ){
//                    cnt --;
//                }
//                if(cnt == 0){
//                    max_cnt = Math.max(i , max_cnt);
//                    break;
//                }
//            }
//            if(cnt > 0){
//                break;
//            }
//        }
//        return  result;
//    }.

    static int len;
    static List<Integer> list;
    public static int solution(int[] A) {
        // write your code in Java SE 8
        len = A.length;
        list = new ArrayList<>();

        for (int i = 1; i < len - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                list.add(i);
                i++;
            }
        }

        int lo = 0;
        int hi = list.size();
        if (hi < 2) return hi;

        int max = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(mid) == mid) {
                lo = mid + 1;
                max = mid;
            } else {
                hi = mid - 1;
            }
        }

        return max;
    }

    private static int check(int num) {
        int prev = list.get(0);
        int cnt = 1;
        for (int i = 1; i < list.size() && cnt < num; i++) {
            if (list.get(i) - prev >= num) {
                cnt++;
                prev = list.get(i);
            }
        }

        return cnt;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,5,3,4,3,4,1,2,3,4,6,2}));
    }
}
