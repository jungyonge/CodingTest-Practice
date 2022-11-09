package com.coding.test.baekjun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BJ_1931 {

// array 정렬 comparator
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();


		/*
		  time[][0] 은 시작시점을 의미
		  time[][1] 은 종료시점을 의미
		*/
        int[][] time = new int[N][2];


        for(int i = 0; i < N; i++) {
            time[i][0] = in.nextInt();	// 시작시간
            time[i][1] = in.nextInt();	// 종료시간
        }


        // 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의
        Arrays.sort(time, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }

                return o1[0] - o2[0];
            }

        });

        int count = 0;
        int prev_end_time = 0;
        int max = 0;

        for(int i = 0; i < N; i++) {

            count = 1;
            prev_end_time = time[i][1];
            for(int j = 0; j < N; j++) {
                if(i == j ){
                    continue;
                }
                // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
                if(prev_end_time <= time[j][0]) {
                    prev_end_time = time[j][1];
                    count++;
                }
            }
            max = Math.max(max,count);

        }

        System.out.println(max);

    }

}
