package com.coding.test.baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HanoiTop {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {

// 		백준 알고리즘 11729번
//		시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//		1 초	256 MB	45658	22461	17386	48.841%
//		문제
//		세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
//
//		한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
//		쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
//		이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = hanoi(N, 1, 2, 3, 0, sb);

        bw.write(String.valueOf(count)+"\n");
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();


    }

    public static int hanoi(int n, int start, int sub, int to, int count, StringBuilder sb) {

        count++;

        System.out.println(count);
        if(n == 1) {
            sb.append(start + " " + to + "\n");
            return count;
        }

        count = hanoi(n-1, start, to, sub, count, sb);
        sb.append(start + " " + to + "\n");
        count = hanoi(n-1, sub, start, to, count, sb);

        return count;
    }
}