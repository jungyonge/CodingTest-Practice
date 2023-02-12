package com.coding.test.programmers.hanhwa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class test1 {

    public static String[] solution(String[] logs) {
        HashSet<String> user = new HashSet<>();
        HashSet<String> logSet = new HashSet<>();
        HashMap<String, Integer> subject = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();
        int cnt;

        for (String log : logs) {
            if(!logSet.contains(log)){
                logSet.add(log);
                String[] tempLog = log.split(" ");
                user.add(tempLog[0]);
                subject.put(tempLog[1], subject.getOrDefault(tempLog[1], 0) + 1);
            }

        }
        if (user.size() % 2 == 0) {
            cnt = user.size() / 2;
        } else {
            cnt = user.size() / 2 + 1;
        }

        for (Map.Entry<String, Integer> entry : subject.entrySet()) {
            if (subject.get(entry.getKey()) >= cnt) {
                answer.add(entry.getKey());
            }
        }

        Collections.sort(answer);
        String[] result = new String[answer.size()];
        result = answer.toArray(result);
        return result;


    }

    public static void main(String[] args) {
//
//        System.out.println(solution(
//            new String[]{"mor str", "fel str", "mor rev", "roh sor", "and rev", "mor sqr"}));

        System.out.println(solution(
            new String[]{"mor sor","fel sor","mor sqr","mor sqr","roh rev","roh rev"}));
    }
}
