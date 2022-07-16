package com.coding.test.programmers.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Ex_44 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, List<String>> ids = new HashMap<>();
        int idx = 0;
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, Integer> sendCount = new HashMap<>();


        for(String reportId : id_list){
            ids.put(reportId, new ArrayList<>());
        }

        for (String s : list) {
            String reportId = s.split(" ")[0];
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);

            for(String reportTempId : id_list){
                if(reportId.equals(reportTempId)){
                    ids.get(reportId).add(target);
                }
            }
        }

        for(String id : id_list){
            int reportCount = count.getOrDefault(id,0);
            if(reportCount >= k){
                for(String tempId : id_list){
                    if(ids.get(tempId).contains(id)){
                        sendCount.put(tempId, sendCount.getOrDefault(tempId, 0) + 1);
                    }
                }
            }
        }

        for(String id : id_list){
            answer[idx++] = sendCount.getOrDefault(id,0);
        }

        return answer;
    }

    public static void main(String[] args) {

        solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
    }

}
