package com.coding.test.baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2644 {

    static int n, p1, p2;
    static int[][] map;
    static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        map = new int[n + 1][n + 1];
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
            map[y][x] = 1;
        }
        d = new int[n + 1];
        BFS(p1, p2);
        if(d[p2]==0)
            System.out.println(-1);
        else {
            System.out.println(d[p2]);
        }

    }

    private static void BFS(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        // 한 점부터 시작한다.
        q.add(start);
        while (!q.isEmpty()) {
            // v를 확인!
            int v = q.poll();
            // 만나면 while문 종료.
            if (v==end) {
                break;
            }
            // map을 돌면서 연결되어 있는 관계 타고 들어가기.
            for (int i = 1; i <= n; i++) {
                // 이미 확인했으면 d[i]가 1 이상이기에 확인하지 않는다.
                if (map[v][i] == 1 && d[i] == 0) {
                    d[i] = d[v] + 1;
                    q.add(i);
                }
            }
        }
    }
}
