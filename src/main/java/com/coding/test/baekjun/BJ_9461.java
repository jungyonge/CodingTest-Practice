package com.coding.test.baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_9461 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] num = new long[n];
        for(int i = 0; i < n ; i++){
            num[i] = scanner.nextInt();
        }
        Arrays.sort(num);
        long max = num[num.length - 1];
        long[] wave = new long[(int) max];
        wave[0] = 1;
        for(int i = 0 ; i < max ; i ++){
            long first = i - 1;
            long second = i - 5;
            long res = 0;
            if(first < 0 && second < 0){
                res = 1L;
            }else if(first >= 0 && second < 0){
                if(second == - 2){
                    res = 2L;
                }else {
                    res = wave[(int) first];
                }
            }else {
                res = wave[(int) first] + wave[(int) second];
            }
            wave[i] = res;
        }

        for(long i : num){
            System.out.println(wave[(int) (i - 1)]);
        }
    }


//    public static Long[] seq = new Long[101];
//
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//
//        seq[0] = 0L;
//        seq[1] = 1L;
//        seq[2] = 1L;
//        seq[3] = 1L;
//
//        int T = in.nextInt();
//
//        while(T-- > 0) {
//            int N = in.nextInt();
//            System.out.println(padovan(N));
//        }
//
//    }
//
//    public static long padovan(int N) {
//        if(seq[N] == null) {	// 탐색하지 않은 인덱스일 경우 재귀호출
//            seq[N] = padovan(N - 2) + padovan(N - 3);
//        }
//        return seq[N];
//    }
}
