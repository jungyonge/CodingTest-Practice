package com.coding.test.supercat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.TreeMap;

public class test3_2 {

//    static class Truck{
//        int max_weight;
//
//        int number;
//
//        Truck(int max_weight,  int number) {
//            this.max_weight = max_weight;
//            this.number = number;
//        }
//
//        public int getNumber() {
//            return number;
//        }
//
//        public void setNumber(int number) {
//            this.number = number;
//        }
//
//        public int getMax_weight() {
//            return max_weight;
//        }
//
//        public void setMax_weight(int max_weight) {
//            this.max_weight = max_weight;
//        }
//
//    }
//
    static int MIN_W = Integer.MIN_VALUE;
    static int MAX_TRUCK = Integer.MIN_VALUE;

    static int[] truck_orignin_weight = new int[150000];

    public static int[] solution(int[] truck, int[] w) {
        int[] answer = new int[w.length];

        Queue<int[]> queue = new LinkedList();

        for(int i = 0 ; i < w.length; i++){
            queue.add(new int[]{w[i], 0});
        }

        HashMap<Integer, Queue<Integer>> truckInfo = new HashMap<>();

        for(int i = 0 ; i < truck.length; i ++){
            truck_orignin_weight[i + 1] = truck[i];
//            MAX_TRUCK = Math.max(truck[i], MAX_TRUCK);
            for(int j = 1 ; j <= truck[i]; j ++){
                Queue<Integer> truckQueue = truckInfo.getOrDefault(j, new LinkedList<>());
                truckQueue.add(i + 1);
                truckInfo.put(j, truckQueue);
            }

        }
        int i = 0;

        while (!queue.isEmpty()) {
            //없을때 -1
            answer[i] = -1;
            //현재 짐 무게 뽑기
            int[] load = queue.poll();
            int now_load = load[0];

            //현재 짐에서 가장 빠른 트럭넘버 뽑기, 설정
            if(truckInfo.get(now_load).size() != 0){
                int truckNumber = truckInfo.get(now_load).peek();
                answer[i] = truckNumber;

                //원래 트럭 load
                int origin_load = truck_orignin_weight[truckNumber];
                //변경된 트럭info

                updateTruckInfo(truckNumber, now_load ,origin_load, truckInfo);
            }
            i++;
        }


        return answer;
    }

    public static void updateTruckInfo(int truckNumber, int now_load, int origin_load, HashMap<Integer, Queue<Integer>>  truckInfo){
        int for_load = origin_load - now_load + 1;
        int last_load = origin_load;
        for(int i = for_load; i <=last_load ; i++){
            Queue<Integer> truckQueue = truckInfo.getOrDefault(i, new LinkedList<>());
            Queue<Integer> newTruckQueue = new LinkedList<>();

            while (!truckQueue.isEmpty()){
                int tempTruckNumber = truckQueue.poll();
                if(truckNumber != tempTruckNumber){
                    newTruckQueue.add(tempTruckNumber);
                }
            }
            truckInfo.put(i, newTruckQueue);
        }
    }
    static int[] dp;
//    public static int[] solution(int[] truck, int[] w) {
//        int[] answer = new int[w.length];
//
//        dp = new int[150000];
//        Queue<Integer> queue = new LinkedList();
//        for(int load : w){
//            queue.add(load);
//        }
//
//        int i = 0;
//        int minIndex = 0;
//        int max = Integer.MIN_VALUE;
//
//        while (!queue.isEmpty()){
//            int load = queue.poll();
//            answer[i] = -1;
//            if(load <= max){
//                minIndex = 0;
//            }
//            for(int j = minIndex; j < truck.length  ; j ++){
//                if(max >= truck[j]){
//                    max = truck[j];
//                    minIndex = j;
//                }
//                if(truck[j] >= load){
//                    truck[j] = truck[j] - load;
//                    answer[i] = j + 1;
//                    break;
//                }
//            }
//            i++;
//        }
//
//        return answer;
//    }

//    public int[] find(){
//
//    }


    public static void main(String[] args) {
//        int[] re = solution(new int[]{1,4,5,2,4}, new int[]{2,4,4,3,2});
        int[] re = solution(new int[]{2,7,4,9}, new int[]{7,6,8});

    }

}
