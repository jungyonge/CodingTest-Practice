package com.coding.test.programmers.dfsbfscodingtest;

public class Ex_2 {


//    dfs

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n]; // n 갯수만큼 boolean 배열을 만들고 모든 요소를 false로 초기화

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(computers, i, check);
                answer++;
            }
        }

        return answer;
    }

    static boolean[] dfs(int[][] computers, int i, boolean[] check) {
        check[i] = true;

        for (int j = 0; j < computers.length; j++) {
            System.out.println(i + 1);
            if (i != j && computers[i][j] == 1 && check[j] == false) {
                check = dfs(computers, j, check);
            }
        }
        return check;
    }

    public static void main(String[] args) {

        solution(3 , new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }
}
