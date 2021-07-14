package com.coding.test.programmers;

import java.util.ArrayList;

public class PowerSet {
    private static char data[]= {'a','b','c','d'};
    private static int n=data.length;
    private static boolean[] include = new boolean[n];

    public static void powerSet(int k,ArrayList res) {
        System.out.format("powerSet(%d) 호출됨.\n",k);
        if(n==k) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++) {
                if(include[i]) {
                    System.out.print(data[i] + " ");
                    sb.append(data[i]);
                }
            }
            if (!res.contains(sb)) {
                res.add(sb);
            }
            System.out.println();
            return;
        }
        System.out.format("집합 %c 원소는 미포함한 부분집합 구하기 powerSet(%d)\n", data[k], k+1);
        include[k]=false;
        powerSet(k+1,res);
        System.out.format("집합 %c 원소를 포함시킨 부분집합 구하기 powerSet(%d)\n", data[k],k+1);
        include[k]=true;
        powerSet(k+1,res);
    }

    public static void powerSet(int k) {
        System.out.format("powerSet(%d) 호출됨.\n",k);
        if(n==k) {
            for(int i=0;i<n;i++) {
                if(include[i])
                    System.out.print(data[i]+" ");
            }
            System.out.println();
            return;
        }
        System.out.format("집합 %c 원소는 미포함한 부분집합 구하기 powerSet(%d)\n", data[k], k+1);
        include[k]=false;
        powerSet(k+1);
        System.out.format("집합 %c 원소를 포함시킨 부분집합 구하기 powerSet(%d)\n", data[k],k+1);
        include[k]=true;
        powerSet(k+1);

    }

    public static void printArray() {
        for(char c: data) {
            System.out.format("%c ",c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList res = new ArrayList();

        powerSet(0,res);
//        powerSet(0);
        System.out.println(res);
    }

}