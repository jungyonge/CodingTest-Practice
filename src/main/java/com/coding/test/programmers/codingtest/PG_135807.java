package com.coding.test.programmers.codingtest;

import java.util.ArrayList;
import java.util.Collections;

public class PG_135807 {


    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        ArrayList<Integer> divA = new ArrayList<>();
        ArrayList<Integer> divB = new ArrayList<>();

        ArrayList<Integer> commonDivA = new ArrayList<>();
        ArrayList<Integer> commonDivB = new ArrayList<>();

        divA = div(arrayA[0]);
        divB = div(arrayB[0]);

        int max = 0;
        for (int i : divA) {
            int cnt = 0;
            for (int j : arrayA) {
                if (j % i == 0) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == arrayA.length) {
                commonDivA.add(i);
            }
        }

        for (int i : divB) {
            int cnt = 0;
            for (int j : arrayB) {
                if (j % i == 0) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == arrayB.length) {
                commonDivB.add(i);
            }
        }

        for (int i : commonDivA) {
            int cnt = 0;
            for (int j : arrayB) {
                if (j % i == 0) {
                    break;
                } else {
                    cnt++;
                }
            }
            if (cnt == arrayB.length) {
                max = Math.max(i, max);
                break;
            }
        }

        for (int i : commonDivB) {
            int cnt = 0;
            for (int j : arrayA) {
                if (j % i == 0) {
                    break;
                } else {
                    cnt++;
                }
            }
            if (cnt == arrayA.length) {
                max = Math.max(i, max);
                break;
            }
        }
        return max;
    }

    public static ArrayList<Integer> div(int num) {
        ArrayList<Integer> div = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                div.add(i);
            }

        }
        Collections.sort(div, Collections.reverseOrder());
        return div;

    }

    public static void main(String[] args) {
        solution(new int[]{14, 35, 119}, new int[]{18, 30, 102});
    }
}

