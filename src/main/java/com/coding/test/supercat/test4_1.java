package com.coding.test.supercat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class test4_1 {

    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;

    static int MIN_INDEX = 0;
    static int MAX_INDEX = 0;
    public static int[] solution(int[] truck, int[] w) {
        int[] answer = new int[w.length];


        Queue<Integer> queue = new LinkedList();

        for(int load : w){
            queue.add(load);
        }

        int i = 0;
        while (!queue.isEmpty()){
            int load = queue.poll();
            int startAt = 0;
            int lastAt = 0;

            if(load < MAX && load > MIN){
                startAt = MIN_INDEX;
                lastAt = MAX_INDEX + 1;
            }

            if(load <= MIN){
                startAt = 0;
                lastAt = MIN_INDEX + 1;
            }

            if(load >= MAX){
                startAt = MAX_INDEX;
                lastAt = truck.length;
            }

            answer[i] = -1;
            for(int j = startAt; j < lastAt  ; j ++){

                if(truck[j] >= load){
                    truck[j] = truck[j] - load;
                    answer[i] = j + 1;
                    if (truck[j] == 0) {
                        MAX = truck[j];
                        MAX_INDEX = 0;

                        MIN = truck[j];
                        MIN_INDEX = j + 1;
                    }
                    if(truck[j] > 0){
                        if(truck[j] > MAX){
                            MAX = truck[j];
                            MAX_INDEX = j;
                        }

                        if(truck[j] < MIN){
                            MIN = truck[j];
                            MIN_INDEX = j;
                        }
                    }
                    break;
                }

                if(truck[j] > 0){
                    if(truck[j] > MAX){
                        MAX = truck[j];
                        MAX_INDEX = j;
                    }

                    if(truck[j] < MIN){
                        MIN = truck[j];
                        MIN_INDEX = j;
                    }
                }

            }
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[] re = solution(new int[]{2,7,4,9}, new int[]{7,6,8});
//        int[] re = solution(new int[]{1,4,5,2,4}, new int[]{2,4,4,3,2});
//        int[] re = solution(new int[]{1,1,1,1,2,2,9}, new int[]{3,3,3,2,2,1,1});

    }
}
