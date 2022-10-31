package com.coding.test.baekjun;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class BIgGuy {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        LinkedList<HashMap> humanList = new LinkedList<>();
        for(int i = 0 ; i < cnt; i++){
            HashMap<String, Integer> human = new HashMap<>();
            human.put("weight", Integer.valueOf(scanner.next()));
            human.put("height", Integer.valueOf(scanner.next()));
            human.put("rank", 1);
            humanList.add(human);
        }

        for(int i = 0 ; i < cnt; i++) {
            HashMap<String, Integer> temp = humanList.get(i);
            for (int j = 0; j < cnt; j++) {
                if (i == j) {
                    continue;
                } else {
                    HashMap<String, Integer> temp2 = humanList.get(j);
                    if (temp.get("weight") < temp2.get("weight") && temp.get("height") < temp2.get(
                            "height")) {
                        temp.put("rank", temp.get("rank") + 1);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(HashMap<String, Integer> tempHuman: humanList){
            sb.append(tempHuman.get("rank") + " ");
        }

        System.out.println(sb.toString());
    }
}
