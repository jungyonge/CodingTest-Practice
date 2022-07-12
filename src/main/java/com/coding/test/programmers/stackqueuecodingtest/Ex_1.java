package com.coding.test.programmers.stackqueuecodingtest;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class Ex_1 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/42586
//    기능개발

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < progresses.length   ; i++){
            int needDay = (100 - progresses[i]) / speeds[i];
            long checkDay = (100 - progresses[i]) % speeds[i];
            if(checkDay > 0 ){
                needDay++;
            }
            queue.add(needDay);
        }
        int dpCnt = 1;
        boolean checkdp = false;

        int now = queue.poll();
        int next = 0;
        while (true){
            if(queue.isEmpty()){
                answerList.add(dpCnt);
                break;
            }else {
                next = queue.poll();
            }

            if(now < next){
                answerList.add(dpCnt);

                dpCnt = 1;
                now = next;
            }else if(now == next){
                answerList.add(++dpCnt);

                if(queue.isEmpty()) {
                    break;
                }
                dpCnt = 1;
                now = next;

            } else {

                dpCnt++;

            }
        }
        answer = answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }


    public static void main(String[] args) {

        solution(new int[]{21, 25, 20}, new int[]{5,5,5});
    }
}
