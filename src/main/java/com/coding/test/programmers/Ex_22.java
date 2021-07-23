package com.coding.test.programmers;

import java.util.ArrayList;

public class Ex_22 {
    public static int solution(String numbers) {
        int answer = 0;
        ArrayList res = new ArrayList();
        String[] dataArr = numbers.split("");
        boolean[] include = new boolean[numbers.length()];
        int n = dataArr.length;
        powerSet(dataArr,include,n,0,res);
        System.out.println(res);
        return answer;
    }


    public static void powerSet(String[] dataArr,boolean[] include , int n, int k, ArrayList res) {
        if(n==k) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++) {
                if(include[i]) {
                    sb.append(dataArr[i]);
                }
            }
            if (!res.contains(sb)) {
                res.add(sb);
            }
            return;
        }
        include[k]=false;
        powerSet(dataArr,include,n,k+1,res);
        include[k]=true;
        powerSet(dataArr,include,n,k+1,res);
    }

    public static void main(String[] args) {
        solution("011");
    }
}
