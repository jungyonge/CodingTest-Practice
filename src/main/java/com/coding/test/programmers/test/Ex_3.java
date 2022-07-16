package com.coding.test.programmers.test;

import java.util.HashMap;

public class Ex_3 {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap();
        int answer = 1;
        int answer2 = 0;

        for (int i = 0; i < clothes.length; i++) { // 아무것도 안입은 상태도 개수로 친다.
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (int i : hm.values()) {
            answer2 += i;
        }

        for (int i : hm.values()) {
            answer *= i;
        }
        //옷을 하나도 입지 않은 상태를 빼준다.
        if(hm.size() == 1){
            return answer2;
        }else {
            return answer+ answer2;
        }
    }

    public static void main(String[] args) {
        String[][] clo = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clo2 =  {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        solution(clo2);
    }
}
