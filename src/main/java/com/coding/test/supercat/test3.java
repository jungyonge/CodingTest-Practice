package com.coding.test.supercat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Stream;

public class test3 {

    static class Truck{
        int max_weight;

        int number;

        Truck(int max_weight,  int number) {
            this.max_weight = max_weight;
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getMax_weight() {
            return max_weight;
        }

        public void setMax_weight(int max_weight) {
            this.max_weight = max_weight;
        }

    }

    static class Load{
        int weight;
        int truckNumber;

        Load(int weight, int truckNumber) {
            this.weight = weight;
            this.truckNumber = truckNumber;

        }

        public int getTruckNumber() {
            return truckNumber;
        }

        public void setTruckNumber(int truckNumber) {
            this.truckNumber = truckNumber;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

//    public static int[] solution(int[] truck, int[] w) {
//        int[] answer = new int[w.length];
//        List<Truck> truckList = new ArrayList<>();
//        List<Load> loadList = new ArrayList<>();
//
//        for(int i = 0 ; i < truck.length ; i ++){
//            Truck newTruck = new Truck(truck[i], i + 1);
//            truckList.add(newTruck);
//        }
//        for(int i = 0 ; i < w.length ; i ++){
//            Load newLoad = new Load(w[i],-1);
//            loadList.add(newLoad);
//        }
//
//        int i = 0;
//        for(Load now_load : loadList){
//
//            for(Truck now_truck : truckList){
//                if(now_truck.getMax_weight() >= now_load.getWeight() && now_load.getTruckNumber() == -1){
//                    now_truck.setMax_weight(now_truck.getMax_weight() - now_load.getWeight());
//                    now_load.setTruckNumber(now_truck.getNumber());
//                    break;
//                }
//            }
//
//            answer[i] = now_load.getTruckNumber();
//
//            i++;
//        }
//
//        return answer;
//    }

    static int MIN_W = Integer.MIN_VALUE;
    public static int[] solution(int[] truck, int[] w) {
        int[] answer = new int[w.length];

        Queue<int[]> queue = new LinkedList();

        for(int i = 0 ; i < w.length; i++){
            MIN_W = Math.min(MIN_W, w[i]);
            queue.add(new int[]{w[i], 0});
        }

        List<int[]> truckArray = new ArrayList<>();
        for(int i = 0 ; i < truck.length; i++){
            if(truck[i] >= MIN_W){
                truckArray.add(new int[]{truck[i], i + 1});
            }
        }

        int i = 0;

        while (!queue.isEmpty()){
            answer[i] = -1;
            int[] load = queue.poll();
            Optional<int[]> temp= truckArray.stream().filter(s-> s[0] >= load[0]).findFirst();
            if(temp.isPresent()){
                answer[i] = temp.get()[1];
                truckArray.get(temp.get()[1] - 1)[0] = truckArray.get(temp.get()[1] - 1)[0] - load[0];
            }
            i++;
        }

//        for(int i = 0 ; i < w.length ; i++){
//            answer[i] = -1;
//            for(int j = 0; j < truck.length  ; j ++){
//                if(truck[j] >= w[i]){
//                    truck[j] = truck[j] - w[i];
//                    answer[i] = j + 1;
//                    break;
//                }
//            }
//
//
//        }

        return answer;
    }


    public static void main(String[] args) {
        int[] re = solution(new int[]{1,4,5,2,4}, new int[]{2,4,4,3,2});
//        int[] re = solution(new int[]{2,7,4,9}, new int[]{7,6,8});

    }


}
