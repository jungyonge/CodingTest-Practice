package com.coding.test.programmers.test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Ex_7 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new ConcurrentLinkedQueue<>();
        int sum = 0;
        for(int t : truck_weights) {
            while(true) {
                if(q.isEmpty()) {
                    q.add(t);
                    sum += t;
                    answer++;
                    break;
                } else if(q.size() == bridge_length) {
                    sum -= q.poll();
                } else {
                    if(sum + t > weight) {
                        answer++;
                        q.add(0);
                    } else {
                        q.add(t);
                        sum+=t;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}
