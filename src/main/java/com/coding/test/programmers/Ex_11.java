package com.coding.test.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Ex_11 {
    public static int[] solution(String[] operations) {
        int[] answer = {};

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(String oper : operations){
            String[] oper_spl = oper.split(" ");
            String command = oper_spl[0];
            int num = Integer.parseInt(oper_spl[1]);
            if(command.equals("I")){
                arrayList.add(num);
                Collections.sort(arrayList);
            }else if(command.equals("D")){
                if(arrayList.size() > 0){
                    if(num == -1){
                        arrayList.remove(0);
                    }else if(num == 1){
                        arrayList.remove(arrayList.size());
                    }
                }
            }
        }

        if(arrayList.size() == 0){
            answer = new int[]{0, 0};
        }else {
            answer = new int[]{arrayList.get(arrayList.size() - 1), arrayList.get(0)};
        }

        return answer;
    }

    public static void main(String[] args) {
//        String[] oper = {"I 16","D 1"};
        String[] oper = {"I 7","I 5","I -5","D -1"};
        solution(oper);
    }
}
