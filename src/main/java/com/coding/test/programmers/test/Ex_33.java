package com.coding.test.programmers.test;

public class Ex_33 {


    public static int solution(int left, int right) {
        int answer = 0;
        int cnt = 0;
        for(int n = left ;  n <= right ; n ++){
            cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    cnt++;
                }
            }
            if(cnt % 2 == 1){
                answer += n * -1;
            }else {
                answer += n;
            }
        }
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        int l = 13;
        int r = 17;
        solution(l,r) ;
    }

}
