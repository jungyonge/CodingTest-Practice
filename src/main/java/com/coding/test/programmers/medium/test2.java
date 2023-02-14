package com.coding.test.programmers.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class test2 {

    static boolean[] visited;
    static char[] letters_array;
    static char[] temp;
    static TreeSet<String> set = new TreeSet<>();
    static int K;

    public static String solution(String letters, int k) {
        K = k;
        visited = new boolean[letters.length()];
        temp = new char[K];
        letters_array = letters.toCharArray();
        dfs(0, 0);

        return set.last();
    }

    public static void dfs(int startAt, int depth) {

        if (K == depth) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < K; i++) {
                sb.append(temp[i]);
            }
            set.add(sb.toString());
            return;
        }
        for (int i = startAt; i < letters_array.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = letters_array[i];
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(solution("zbgaj", 3));
    }
}
