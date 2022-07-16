package com.coding.test.programmers.test;

import java.util.ArrayList;

public class Ex_28 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> boxArr = new ArrayList<>();
        for(int i = 0 ; i < board[0].length ; i ++){
            ArrayList<Integer> tempArr = new ArrayList<>();
            for(int j = board.length - 1 ; j >= 0  ; j --){
                System.out.println(board[j][i]);
                if(board[j][i] != 0){
                    tempArr.add(board[j][i]);
                }
            }
            arrayList.add(tempArr);
        }

        for(int i : moves){
            if(arrayList.get(i - 1).size() != 0){
                boxArr.add(arrayList.get(i - 1).get(arrayList.get(i- 1).size() - 1));
                arrayList.get(i - 1).remove(arrayList.get(i-1).size() - 1);
            }
            System.out.println(boxArr.toString());
            if(boxArr.size() >= 2){
                int present = boxArr.size() - 1;
                int prev = boxArr.size() - 2;

                if(boxArr.get(present) == boxArr.get(prev)){
                    boxArr.remove(present);
                    boxArr.remove(prev);
                    answer = answer +2;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] move = {1,5,3,5,1,2,1,4};

        solution(board, move);

    }
}

