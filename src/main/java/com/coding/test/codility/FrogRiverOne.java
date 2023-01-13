package com.coding.test.codility;

public class FrogRiverOne {

    public static int solution(int X, int[] A) {
        boolean[] visited = new boolean[X + 1];
        int check = 0;
        int result = -1;

        for(int i = 0 ; i < A.length ; i++){
            if(A[i] <= X && !visited[A[i]]){
                visited[A[i]] = true;
                check++;
            }

            if(check == X){
                result = i;
                break;
            }
        }

        return result;
        // Implement your solution here
    }

    public static void main(String[] args) {

        solution(5, new int[]{1,3,1,4,2,3,5,4});
    }

}
