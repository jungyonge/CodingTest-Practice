package com.coding.test.programmers.stackqueuecodingtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Ex_3 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/42583
//    다리지나는 트럭

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        List<Truck> truckList = new ArrayList<>();
        Queue<Truck> bridgeQueue = new LinkedList<>();
        Queue<Truck> waitQueue = new LinkedList<>();
        int nowBridgeWeigh = 0;

        for(int truckWe : truck_weights){
            Truck truck = new Truck(truckWe,0, false);
            waitQueue.add(truck);
            truckList.add(truck);
        }

        while (true){
            if(!bridgeQueue.isEmpty() || !waitQueue.isEmpty()){
                answer++;

                if(!bridgeQueue.isEmpty()){
                    int pollCnt = 0;
                    for(Truck truck : bridgeQueue){
                        if(truck.getTime() == bridge_length && pollCnt == 0){
                            pollCnt++;
                            nowBridgeWeigh -= truck.getWeight();
                        }
                    }
                    if (pollCnt != 0){
                        bridgeQueue.poll();
                    }

                    for(Truck truck : bridgeQueue){
                        truck.setTime(truck.getTime() + 1);
                    }
                    if(bridgeQueue.isEmpty() && waitQueue.isEmpty()){
                        break;
                    }
                }

                if (!waitQueue.isEmpty() && weight >= nowBridgeWeigh + waitQueue.peek()
                        .getWeight()) {
                    int bridgeTime = 1;
                    Truck truck = waitQueue.poll();
                    nowBridgeWeigh += truck.getWeight();
                    truck.setOnBridge(true);
                    truck.setTime(bridgeTime);
                    bridgeQueue.offer(truck);
                }


            } else {
                break;
            }

        }


        return answer;

    }

    static class Truck{
        int weight;
        int time;
        boolean onBridge;

        Truck(int weight, int time, boolean onBridge) {
            this.weight = weight;
            this.time = time;
            this.onBridge = onBridge;
        }

        int getWeight() {
            return weight;
        }
        int getTime() {
            return time;
        }
        boolean getOnBridge(){
            return onBridge;
        }

        void setTime(int time){
            this.time = time;
        }

        void setOnBridge(boolean onBridge){
            this.onBridge = onBridge;
        }
    }

    public static void main(String[] args) {


        solution(100, 100 , new int[] {10,10,10,10,10,10,10,10,10,10});

        List<String> list = new ArrayList();
        list.add("apple");
        list.add("melon");
        list.add("banana");

        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            if("melon".equals(iter.next()) || "banana".equals(iter.next())) {
                System.out.println(iter.next());
                iter.remove();
            }
        }

        System.out.println(list);
    }
}
