package com.coding.test.programmers;

public class Ex_40 {
    public static long solution(long w, long h) {
        long answer = 1;
        long gdc = GCD(w,h);
        long newW = w / gdc;
        long newH = h / gdc;
        long del = 0;
        if(newH - newW == 1){
            del =  newH + newW - 1 ;
        }else {
            del =  newH * gdc;
        }
        answer = (h * w) - del;
        return answer;
    }

    static long GCD(long a, long b){ // 최대공약수
        if (a%b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }

    public static void main(String[] args) {
        int w = 10;
        int h = 6;

        solution(w,h);
    }
}
