package com.coding.test.baekjun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Goldbah {

//    https://www.acmicpc.net/problem/9020
    // 소수 구하기 prime
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> primeList = new ArrayList<>();
        for (int i = 1; i < 10001; i++) {
            boolean res = is_prime(i);
            if (res) {
                primeList.add(i);
            }
        }
        int cnt = scanner.nextInt();

        for (int i = 0; i < cnt; i++) {
            int primeNumber = scanner.nextInt();
            int temp1 = primeNumber / 2;
            if (primeList.contains(temp1)) {
                System.out.println(temp1 + " " + temp1);
            } else {
                for(int j = 0 ; j < temp1; j ++){
                    temp1--;
                    if(!primeList.contains(temp1)){
                        continue;
                    }
                    int temp = primeNumber - temp1;
                    if (primeList.contains(temp)) {
                        System.out.println(temp1 + " " + temp);
                        break;
                    }
                }
            }
        }
    }

    // 소수 판별 메소드
    public static boolean is_prime(int number) {

        // 0 과 1 은 소수가 아니다
        if (number < 2) {
            return false;
        }

        // 2 는 소수다
        if (number == 2) {
            return true;
        }

        for (int i = 2; i < number; i++) {

            // 소수가 아닐경우
            if (number % i == 0) {
                return false;
            }
        }
        // 위 반복문에서 약수를 갖고 있지 않는경우 소수다.
        return true;
    }

}

