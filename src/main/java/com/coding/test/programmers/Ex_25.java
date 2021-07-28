package com.coding.test.programmers;

import java.util.ArrayList;
import java.util.List;

public class Ex_25 {
    public static int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int num : nums){
            if(!arr.contains(num)){
                arr.add(num);
            }
        }
        if(arr.size() >= nums.length/2){
            return nums.length/2;
        }else {
            return arr.size();
        }
    }

    private static void reculsion(List<Integer> arr, List<Integer> temp, List<String> result, int index, int n, int r) {

        if (r == 0) {
            result.add(temp.toString());
            return;
        }

        for (int i = index; i < n; i++) {
            temp.add(arr.get(i));
            reculsion(arr,temp, result, i + 1, n, r - 1);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        solution(nums);
        System.out.println(nums);
    }
}
