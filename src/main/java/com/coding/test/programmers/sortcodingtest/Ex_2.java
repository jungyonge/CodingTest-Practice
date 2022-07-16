package com.coding.test.programmers.sortcodingtest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Ex_2 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/42746
//    가장 큰 수

//    public static String solution(int[] numbers) {
//        String answer = "";
//        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
//        List<Integer> temp = new ArrayList<>();
//        List<Integer> result = new ArrayList<>();
//
//        reculsion(list, temp, result, list.size(), list.size());
//
//        if(result.size() == 0){
//            return "0";
//        }
//        answer = result.stream()
//                .max(Comparator.comparing(x -> x))
//                .orElseThrow(NoSuchElementException::new).toString();
//        System.out.println(answer);
//        return answer;
//    }

    public static String solution(int[] numbers) {
        String[] nums = new String[numbers.length];

        for (int i=0; i<nums.length; i++)
            nums[i] = numbers[i] + "";

        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        String ans = "";
        for (int i=0; i<numbers.length; i++)
            ans += nums[i];

        return ans.charAt(0) == '0' ? "0" : ans;
    }

    private static void reculsion(List<Integer> arr, List<Integer> temp, List<Integer> result, int n, int r) {


        if (r == 0) {
            StringBuilder tempString = new StringBuilder();

            for(int i = 0 ; i < temp.size() ; i++){
                if( temp.get(0) == 0){
                    return ;
                }
                tempString.append(temp.get(i));
            }
            result.add(Integer.parseInt(tempString.toString()));
            return ;
        }

        for (int i = 0; i < n; i++) {
            temp.add(arr.remove(i));
            reculsion(arr, temp, result, n - 1, r - 1);
            arr.add(i, temp.remove(temp.size() - 1));
        }

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 30, 34, 5, 9,99}));
    }
}
