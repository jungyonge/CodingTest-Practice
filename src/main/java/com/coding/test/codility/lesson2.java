package com.coding.test.codility;

import java.util.HashMap;

public class lesson2 {

    public static int solution(int[] A) {
        int result = -1;
        if(A.length == 0 || A.length == 1){
            return result;
        }
        int target = 0;
        int max = 0;
        boolean duple = false;
        int half_num = 0;
        if(A.length % 2 == 1){
            half_num  = A.length / 2 + 1;
        }else {
            half_num  = A.length / 2 ;

        }

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        int j = 0;
        for(int i : A){
           map.put(i, map.getOrDefault(i,0) + 1);
           indexMap.put(i,j);
           j++;
        }

        for( Integer key : map.keySet() ){
            Integer value = map.get(key);
            if(max == value){
                duple = true;
            }
            if(value >= half_num && value > max){
                target = key;
                max = value;
                duple = false;
            }
        }
        if(!duple){
            result = indexMap.get(target);
        }

        if(indexMap.get(target) == 0 || indexMap.get(target) == A.length){
            result = -1;
        }

        return result;
    }
    public static void main(String[] args) {

        int rr = solution(new int[]{0,0,1,1,1});
        System.out.println(rr);
    }
}
