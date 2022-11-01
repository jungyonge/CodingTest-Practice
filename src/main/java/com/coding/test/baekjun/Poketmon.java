package com.coding.test.baekjun;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Poketmon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int monCount = scanner.nextInt();
        int examCount = scanner.nextInt();
        LinkedList<String> monList = new LinkedList<>();
        HashMap<Object, Object> map = new HashMap<>();
        for(int i = 0 ; i < monCount; i++){
            String mon = scanner.next();
            map.put(mon, i + 1);
            map.put(i + 1, mon);
        }

        for(int i = 0 ; i < examCount; i++){
            String exam = scanner.next();
            try {
                int temp = Integer.parseInt(exam);
                System.out.println(map.get(temp));
            }catch(NumberFormatException e) {
                System.out.println(map.get(exam));
            }
        }

    }
}
