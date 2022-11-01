package com.coding.test.baekjun;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Nodud {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int cnt2 = scanner.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cnt; i++) {
            String name = scanner.next();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<String > nameList = new ArrayList<>();
        for (int i = 0; i < cnt2; i++) {
            String name = scanner.next();
            if (map.get(name) != null) {
                sum++;
                nameList.add(name);
            }
        }
        Collections.sort(nameList);
        for(String s : nameList){
            sb.append(s).append("\n");
        }
        System.out.println(sum);
        System.out.println(sb);
    }

}
