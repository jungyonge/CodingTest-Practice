package com.coding.test.programmers;

public class Ex_30 {
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0 ; i < absolutes.length; i++){
            if(signs[i]){
                answer += absolutes[i];
            }else {
                answer -= absolutes[i];
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] abs = {4,7,12};
        boolean[] sig = {true,false,true};
        solution(abs,sig);
    }
}
