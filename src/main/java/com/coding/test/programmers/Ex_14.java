package com.coding.test.programmers;

import java.util.ArrayList;

public class Ex_14 {
    public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] first_ans = {1,2,3,4,5};
        int[] second_ans = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third_ans = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        ArrayList<int[]> answer_list = new ArrayList();
        answer_list.add(first_ans);
        answer_list.add(second_ans);
        answer_list.add(third_ans);

        for(int[] ans : answer_list){

        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
