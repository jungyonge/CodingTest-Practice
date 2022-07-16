package com.coding.test.programmers.test;

import java.util.HashMap;

public class Ex_1 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        System.out.println(hm);
        for (String player : completion) hm.put(player, hm.get(player) - 1);
        System.out.println(hm);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        String ans = solution(participant,completion);
        System.out.println(ans);
    }
}
