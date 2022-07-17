package com.coding.test.programmers.greadycodingtest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Ex_4 {

    public static int solution(int[] people, int limit) {
        int answer = 0;

        int limit2 = limit;
        int onbaout = 2;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0 ; i < people.length; i++){
            queue.offer(people[i]);
        }
        while (true){
            for(int i = 0 ; i < queue.size(); i++){
                int now = queue.poll();
                if(limit2 - now >= 0){
                    limit2 = limit2 - now;
                    onbaout--;
                }else {
                    queue.offer(now);
                }

                if(limit2 == 0 || onbaout == 0){
                    limit2 = limit;
                    break;
                }
            }
            limit2 = limit;
            onbaout = 2;
            answer++;


            if(queue.isEmpty()){
                break;
            }
        }
        return answer;
    }


    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0, first = 0, last = people.length - 1;

            Arrays.sort(people);

            while (first <= last) {
                answer += 1;
                if (people[first] + people[last] <= limit) {
                    first += 1;
                }
                last -= 1;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        solution(new int[]{70,50,80,50}, 100);
    }
}
