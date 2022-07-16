package com.coding.test.programmers.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ex_9 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(Integer scov : scoville){
            arrayList.add(scov);
        }
        int mix_scov = 0;
        while (true){
            Collections.sort(arrayList);
            if(arrayList.get(0) < K){
                mix_scov = arrayList.get(0) + (arrayList.get(1) * 2);
                arrayList.add(0, mix_scov);
                arrayList.remove(1);
                arrayList.remove(1);
                answer++;
            }else {
                break;
            }

        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        solution(scoville,K);

    }
}
