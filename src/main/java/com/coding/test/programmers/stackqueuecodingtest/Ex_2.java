package com.coding.test.programmers.stackqueuecodingtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ex_2 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/42587
//    프린트

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> resultArray = new ArrayList<>();

        Queue<Item> queue = new LinkedList<>();

        for (int i = 0 ; i < priorities.length ; i++) {
            queue.add(new Item(priorities[i], i));
        }

        int preQueueSize = 0;

        while(!queue.isEmpty()) {

            preQueueSize = queue.size();

            Item item = queue.poll();

            Iterator<Item> it = queue.iterator();

            while(it.hasNext()) {
                if (it.next().getPriority() > item.getPriority()) {
                    queue.add(item);
                    break;
                }
            }

            if (queue.size() != preQueueSize) {
                resultArray.add(item.location);
            }
        }

        answer = resultArray.indexOf(location) + 1;

        return answer;
    }

    public static class Item {
        int priority;
        int location;

        Item(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }

        int getPriority() {
            return priority;
        }
        int getLocation() {
            return location;
        }
    }

    public static void main(String[] args) {

        solution(new int[]{2,1,3,2} , 2);
    }
}
