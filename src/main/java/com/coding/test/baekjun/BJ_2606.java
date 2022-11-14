package com.coding.test.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2606 {

    //dfs
    //그래프
    //연결된 감염된 컴퓨터 갯수


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Stack<Integer> stack = new Stack<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 정점들의 정보를 기록할 그래프
    static int[] check; // 방문한 정점을 기록할 배열
    static int count; // 방문 순서
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int edge = Integer.parseInt(st.nextToken());

        // 방문한 정점이 최대 정점의 개수만큼 있기 때문에, 정점의 개수만큼의 크기로 배열 생성
        // index 혼란을 방지하고자 0번 인덱스를 더미 데이터로 활용
        check = new int[vertex + 1];

        visited = new boolean[vertex + 1];
        // graph의 index를 정점의 개수만큼 만들어줌
        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());

            // 무방향이기 때문에 양쪽으로 정보를 추가
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        count = 0;
        dfs(1);
        System.out.println(count - 1);
    }

    public static void dfs(int start) {

        if (!visited[start]) {
            count++;
            visited[start] = true;
            for (Integer temp : graph.get(start)) {
                dfs(temp);
            }
        }
    }
}
