package com.coding.test.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GR_159697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;


    public static void main(String[] args) throws Exception {
        int[] a_cake = new int[3];
        int[] c_cake = new int[3];
        int[] b_cake = new int[3];

        for(int i = 0 ; i < 2; i ++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < 3; j ++){
                if(i == 0 ){
                    a_cake[j] = Integer.parseInt(st.nextToken());
                }else {
                    c_cake[j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        b_cake[0] = c_cake[0] - a_cake[2];
        b_cake[1] = c_cake[1] / a_cake[1];
        b_cake[2] = c_cake[2] - a_cake[0];

        Arrays.stream(b_cake).forEach(x -> sb.append(x).append(" "));

        System.out.println(sb.toString());
    }

}
