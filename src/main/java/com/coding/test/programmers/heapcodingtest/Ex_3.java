package com.coding.test.programmers.heapcodingtest;

import com.coding.test.programmers.heapcodingtest.Ex_2.Job;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ex_3 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/42628
//    이중우선순위큐

    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        Queue<Item> itemQueue = new LinkedList<>();
        for (String temp : operations) {
            String[] tempArr = temp.split(" ");
            Item tempItem = new Item(tempArr[0], Integer.parseInt(tempArr[1]));
            itemQueue.offer(tempItem);
        }

        ArrayList<Integer> itemPriorityQueue = new ArrayList<>();

        while (true) {
            if (!itemQueue.isEmpty()) {
                Item nowItem = itemQueue.poll();

                if (nowItem.getCommand().equals("I")) {
                    itemPriorityQueue.add(nowItem.getNumber());
                    Collections.sort(itemPriorityQueue);
                } else if (nowItem.getCommand().equals("D") && !itemPriorityQueue.isEmpty()) {
                    if (nowItem.getNumber() < 0 && !itemPriorityQueue.isEmpty()) {
                        itemPriorityQueue.remove(0);
                    } else if (nowItem.getNumber() > 0 && !itemPriorityQueue.isEmpty()) {
                        itemPriorityQueue.remove(itemPriorityQueue.size() - 1);
                    }
                }
                System.out.println(nowItem.getCommand());
            } else {
                break;
            }
        }

        if (itemPriorityQueue.isEmpty()) {
            return answer;
        } else {
            answer[0] = itemPriorityQueue.get(itemPriorityQueue.size() - 1);
            answer[1] = itemPriorityQueue.get(0);
            return answer;
        }
    }

    class Item implements Comparable<Item> {

        String command;
        int number;

        public Item(String command, int number) {
            this.command = command;
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public String getCommand() {
            return command;
        }

        @Override
        public int compareTo(Item o) {
            if (this.number > o.number) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {

        Ex_3 ex_3 = new Ex_3();
        ex_3.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1",
                "I 333"});
    }
}


