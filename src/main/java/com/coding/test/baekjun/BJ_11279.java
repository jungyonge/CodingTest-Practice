package com.coding.test.baekjun;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_11279 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());

        int cnt = scanner.nextInt();

        for(int i = 0 ; i < cnt; i++){
            int temp = scanner.nextInt();
            if(temp == 0){
                if(priorityQueueHighest.isEmpty()){
                    System.out.println(0);
                }else {
                    System.out.println(priorityQueueHighest.poll());
                }
            }else {
                priorityQueueHighest.add(temp);
            }
        }
    }
}
