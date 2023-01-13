package com.coding.test.codility;

import java.util.HashMap;

public class OddOccurrencesInArray {

    public static int solution(int[] A) {
        int result = 0;
        // Implement your solution here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for( Integer key : map.keySet() ){
            int cnt = map.get(key);
            if(cnt % 2 == 1){
                result = key;
                break;
            }

        }
        return result;
    }

    public static void main(String[] args) {

    }
}
