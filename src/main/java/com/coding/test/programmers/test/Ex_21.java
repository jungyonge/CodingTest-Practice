package com.coding.test.programmers.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex_21 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        ArrayList<Integer> lostArr = (ArrayList<Integer>) Arrays.stream(lost).boxed().collect(Collectors.toList());
        ArrayList<Integer> reserveArr = (ArrayList<Integer>) Arrays.stream(reserve).boxed().collect(Collectors.toList());

        for (int j = 0 ; j< reserveArr.size() ;j ++ ) {
            int i = reserveArr.get(j);
            if (lostArr.contains(i)) {
                lostArr.remove(lostArr.indexOf(i));
                reserveArr.remove(reserveArr.indexOf(i));
                answer++;
            }
        }

        for (int j = 0 ; j< reserveArr.size() ;j ++ ) {
            int i = reserveArr.get(j);
            if (lostArr.contains(i - 1)) {
                lostArr.remove(lostArr.indexOf(i - 1));
                answer++;
            } else if (lostArr.contains(i + 1)) {
                lostArr.remove(lostArr.indexOf(i + 1));
                answer++;
            }
        }
        System.out.println(answer);
        return answer;

    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1,  3,5};
        solution(n, lost, reserve);

    }
}
