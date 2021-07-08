package com.coding.test.programmers;

import java.util.ArrayList;

public class Ex_8 {
    public static int[] solution(int[] prices) {

        ArrayList<Integer> answerList = new ArrayList<>();
        ArrayList<Integer> resList = new ArrayList<>();

        for (Integer price : prices) {
            answerList.add(price);
        }

        for (int i = 0; i < answerList.size(); i++) {
            int sec = 0;
            int target = answerList.get(i);
            for (int j = i + 1; j < answerList.size(); j++) {
                int compare_target = answerList.get(j);

                if (target <= compare_target) {
                    sec += 1;
                } else {
                    sec += 1;
                    resList.add(sec);
                    break;
                }
                if (j == answerList.size() - 1) {
                    resList.add(sec);
                    break;
                }
            }
        }
        resList.add(0);

        int[] ans = new int[resList.size()];
        int i = 0;
        for (Integer sec : resList) {
            ans[i] = sec;
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] price = {1, 2, 3, 2, 3};
        int[] res = new int[5];

        res = solution(price);
        System.out.println(res);
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = i+1; j < answer.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j-i;
                    break;
                }
                if (j==answer.length-1) answer[i] = j-i;
            }
        }
        return answer;
    }
}
