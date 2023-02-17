package com.coding.test.programmers.inka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class test2 {


    public static int solution(int[][] matrix) {
        int answer = 0;
        int mid = matrix.length / 2;
        ArrayList<ArrayList<Integer>> lineList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> rowList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            ArrayList<Integer> tempRow = new ArrayList<>();
            ArrayList<Integer> tempLine = (ArrayList<Integer>) Arrays.stream(matrix[i]).boxed()
                .collect(Collectors.toList());

            for (int j = 0; j < matrix.length; j++) {
                tempRow.add(matrix[j][i]);
            }

            rowList.add(tempRow);
            lineList.add(tempLine);

        }

        for (int i = 0; i < matrix.length; i++) {
            ArrayList<Integer> tempRow = rowList.get(i);

            for (int j = 0; j < matrix.length; j++) {
                ArrayList<Integer> tempLine = lineList.get(j);
                Collections.sort(tempLine);
                Collections.sort(tempRow);
                if (tempLine.get(mid).equals(tempRow.get(mid))) {
                    answer++;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(
            new int[][]{{1, 19, 20, 8, 25}, {21, 4, 3, 17, 24}, {12, 5, 6, 16, 15},
                {11, 18, 10, 9, 23}, {7, 13, 14, 22, 2}}));
    }
}
