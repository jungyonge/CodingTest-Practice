package com.coding.test.baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_16953 {

    static long MIN_COUNT = Integer.MAX_VALUE;
    static boolean check = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long start = in.nextInt();
        long end = in.nextInt();
        BFS(start, end);
        if (check) {
            System.out.print(MIN_COUNT + 1);
        } else {
            System.out.print(-1);
        }
    }


    private static void BFS(long start, long end) {
        Queue<long[]> q = new LinkedList<>();
        // 한 점부터 시작한다.
        q.add(new long[]{start, 0});
        while (!q.isEmpty()) {
            // v를 확인!
            long[]v = q.poll();
            // 만나면 while문 종료.
            if (v[0] == end) {
                check = true;
                MIN_COUNT = Math.min(MIN_COUNT,v[1]);
            }

            long temp = v[0] * 2;
            if (temp <= end) {
                q.add(new long[]{temp, v[1]+ 1});
            }
            temp = Long.parseLong(v[0] + "1");
            if (temp <= end) {
                q.add(new long[]{temp, v[1]+ 1});
            }


        }
    }
}
