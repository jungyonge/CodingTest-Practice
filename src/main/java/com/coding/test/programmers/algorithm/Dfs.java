package com.coding.test.programmers.algorithm;

public class Dfs {
    static int[] visit = new int[];
    public static void dfs(int i) {
        visit[i] = true;
        System.out.print(i + " ");
        for(int j=1; j<n+1; j++) {
            if(map[i][j] == 1 && visit[j] == false) {
                dfs(j);
            }
        }
    }
}
