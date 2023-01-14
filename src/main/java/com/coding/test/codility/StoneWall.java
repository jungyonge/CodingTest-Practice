package com.coding.test.codility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class StoneWall {

    static int min_height = Integer.MAX_VALUE;
    public static int solution(int[] H) {
        int result = 0;

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Set<Integer>> list = new ArrayList<>();
        Set<Integer> each_list = new HashSet<>();
        min_height = H[0];
        for(int i = 0 ; i < H.length; i ++){
            if(min_height > H[i]){
                list.add(each_list);
                min_height = H[i];
                each_list = new HashSet<>();
            }
            each_list.add(H[i]);
        }
        list.add(each_list);
        for(int i = 0 ; i < list.size(); i ++){
            result = result + list.get(i).size() - 1;
        }
        result = result + list.size();
        return result;
        // Implement your solution here
    }
    public static void main(String[] args) {

        System.out.println(solution(new int[]{8,8,5,7,9,8,7,4,8}));
    }
}
