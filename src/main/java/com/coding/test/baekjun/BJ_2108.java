package com.coding.test.baekjun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BJ_2108 {

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int MAX_COUNT = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap();
        int cnt = scanner.nextInt();
        int[] array = new int[cnt];
        int sec = 0;
        for(int i = 0 ; i < cnt ; i ++){
            array[i] = scanner.nextInt();
            MAX = Math.max(MAX, array[i]);
            MIN = Math.min(MIN, array[i]);
            map.put(array[i], map.getOrDefault(array[i], 0 ) + 1);
            MAX_COUNT = Math.max(MAX_COUNT, map.get(array[i]));
        }
        List<Integer> keys = new ArrayList<>(map.keySet()); // ["sangsangss1", "sangsangss2", ...]

        if(keys.size() > 1){
            if(MAX_COUNT > 1){
                Collections.sort(keys, (v1, v2) -> (map.get(v2).compareTo(map.get(v1))));
                if(map.get(keys.get(0)) > map.get(keys.get(1)) ){
                    if(keys.get(0) > keys.get(1)){
                        sec = keys.get(0);
                    }else {
                        sec = keys.get(1);
                    }
                }else {
                    if(keys.get(0) > keys.get(1)){
                        sec = keys.get(0);
                    }else {
                        sec = keys.get(1);
                    }
                }
            }else {
                Collections.sort(keys, Integer::compareTo);
                if(keys.get(0) > keys.get(1)){
                    sec = keys.get(0);
                }else {
                    sec = keys.get(1);
                }
            }
        }else {
            sec = keys.get(0);
        }


        Arrays.sort(array);

        double avg = Math.round(Double.parseDouble(String.valueOf(Arrays.stream(array).sum()))/cnt);

        System.out.println((int)avg);
        System.out.println(array[cnt / 2]);
        System.out.println(sec);
        System.out.println(MAX - MIN);


    }
}
