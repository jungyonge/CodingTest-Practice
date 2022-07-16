package com.coding.test.programmers.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex_22 {
    public static int solution(String numbers) {
        int answer = 0;
        List<String> arr = new ArrayList<>(Arrays.asList(numbers.split("")));


        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        for(int i = 0 ; i < arr.size(); i++){
            reculsion(arr, temp, result, arr.size(), i+1);
        }
        System.out.println(result.toString());
        System.out.println(result.size());
        answer = result.size();
        return answer;
    }


    private static void reculsion(List<String> arr, List<String> temp, List<String> result, int n, int r) {


        if (r == 0 && !temp.get(0).equals("0")) {
            StringBuilder sb = new StringBuilder();
            for(String str : temp){
                sb.append(str);
            }
            if(!result.contains(String.valueOf(sb)) && !isPrime(sb.toString())){
                result.add(String.valueOf(sb));
            }
            return ;
        }

        for (int i = 0; i < n; i++) {
            temp.add(arr.remove(i));
            reculsion(arr, temp, result, n - 1, r - 1);
            arr.add(i, temp.remove(temp.size() - 1));
        }

    }

    private static boolean isPrime(String str) {
        boolean isPrime = false;
        int num = Integer.parseInt(str);
        if(num <= 1){
            return true;
        }
        for (int i = 2; i < num; i++) {
            // 1과 num 자신 외에 나누어지는 수가 있는지 검사할 조건문
            if (num % i == 0) {
                // 나누어지는 수가 있을 경우 isPrime의 값을 true로 바꾼다.
                isPrime = true;
                // 한 번이라도 이 조건문이 실행될 경우 num은 소수가 아니므로 반복문을 빠져나온다.
                break;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        solution("17");
        solution("011");

    }
}
