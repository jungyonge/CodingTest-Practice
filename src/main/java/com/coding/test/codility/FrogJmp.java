package com.coding.test.codility;

public class FrogJmp {

    public static int solution(int X, int Y, int D) {

        int result = 0 ;
        int gap = Y - X;
        if(gap % D == 0){
            result = gap / D;
        } else if (gap % D > 0) {
            result = (gap / D) + 1;
        }

        return result;
        // Implement your solution here
    }
    public static void main(String[] args) {


    }
}
