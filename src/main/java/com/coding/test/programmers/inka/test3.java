package com.coding.test.programmers.inka;

public class test3 {

    public static int solution(int n, int m, int k) {
        int answer = 0;
        int[] bombCount = new int[n];

        int tagger = 0;

        while (true) {
            bombCount[tagger] = bombCount[tagger] + 1;
            if(bombCount[tagger] == m){
                break;
            }
            if(checkOdd(bombCount[tagger])){
                tagger = (tagger + k) % n;
            }else {
                if(tagger - k < 0){
                    tagger = (tagger - k) % n + n;
                }else {
                    tagger = tagger - k;
                }
            }
            answer++;
        }

        return answer;
    }

    public static boolean checkOdd(int number) {
        if (number % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
//        System.out.println(Math.abs(0 - 2));
//        System.out.println(Math.abs(0 - 2) + 1);
//        System.out.println(-4 % 3);

        System.out.println(solution(3, 3, 2));

    }

}
