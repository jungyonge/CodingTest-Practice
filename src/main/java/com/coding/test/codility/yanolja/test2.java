package com.coding.test.codility.yanolja;

import java.util.ArrayDeque;
import java.util.Deque;

public class test2 {

    static int cnt = Integer.MAX_VALUE;

    public static int solution(int[] A) {
        Deque<Integer> originalDeque = new ArrayDeque<>();

        for (int a : A) {
            originalDeque.add(a);
        }

        dfs(originalDeque, 0);

        return cnt;
    }

    public static boolean dfs(Deque<Integer> originalDeque, int count) {

        int sum = 0;
        Deque<Integer> newDeque = new ArrayDeque<>();
        Deque<Integer> tempDeque = new ArrayDeque<>();

        while (!originalDeque.isEmpty()) {
            if (originalDeque.size() == 1) {
                originalDeque.pollFirst();
                cnt = Math.min(cnt, count);
                return true;
            }

            int now = originalDeque.pollFirst();

            if ((sum + now == 0 && originalDeque.peekFirst() < 0) || sum + now < 0) {
                originalDeque.add(now);
                tempDeque.addAll(newDeque);
                tempDeque.addAll(originalDeque);
                if (dfs(tempDeque, count + 1)) {
                    break;
                }
                tempDeque = new ArrayDeque<>();
            } else {
                newDeque.add(now);
                sum = sum + now;

            }
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{10,-10,-1,-1,10}));
//        System.out.println(solution(new int[]{-1,-1,-1,1,1,1,1}));
//        System.out.println(solution(new int[]{5,-2,-3,1}));
        System.out.println(solution(new int[]{10, -10, -10, 2, 3, -10, 5, 6}));


    }
}
