package com.coding.test.programmers.heapcodingtest;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Ex_1 {


//    https://school.programmers.co.kr/learn/courses/30/lessons/42626
//    더 맵게
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int checkScov = 0;
        PriorityQueue<Integer> priorityQueue =  new PriorityQueue<>();

        priorityQueue = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));



        while (true){

            for(Integer scov : priorityQueue){

                if(priorityQueue.size() == 1 && priorityQueue.peek() < K){
                    return -1;
                }else if (priorityQueue.size() == 1 && priorityQueue.peek() >= K){
                    return answer;
                }

                if(scov <= K){
                    checkScov = 0;
                    break;
                } else {
                    checkScov++;
                }
                if(priorityQueue.size() > 1 && checkScov == priorityQueue.size()){
                    return answer;
                }
            }

            if(!priorityQueue.isEmpty() && priorityQueue.size() >= 2){
                priorityQueue.offer(priorityQueue.poll() + ( priorityQueue.poll() * 2));
                answer++;
            }else {
                break;
            }

        }

        return answer;
    }
    public static void main(String[] args) {

        System.out.println(solution(new int[]{0,0,0,0},3));
    }
}
