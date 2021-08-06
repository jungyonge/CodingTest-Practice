package com.coding.test.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Ex_34 {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int all = stages.length;
        ArrayList<Double> failArr = new ArrayList<>();
        HashMap<Integer,Double> temp = new HashMap();

        for(int i = 1 ; i <= N; i++){
            int fail = 0;
            for(int stage : stages){
                if (stage <= i && stage >= i){
                    fail++;
                }
            }
            if(all == 0){
                temp.put(i,0.0);
                failArr.add(0.0);
            }else {
                temp.put(i, (double) fail / all );
                failArr.add((double) fail / all);
            }
            all -= fail;

        }
        Collections.sort(failArr,Collections.reverseOrder());
        int inx = 0;
        for(Double fail : failArr){
            for(Integer key : temp.keySet()){
                if(temp.get(key).equals(fail)){
                    answer[inx] = key;
                    inx++;
                    temp.remove(key);
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        solution(N,stages);
    }
}
