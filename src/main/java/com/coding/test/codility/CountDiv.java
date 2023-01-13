package com.coding.test.codility;

public class CountDiv {
    public static int solution(int A, int B, int K) {
        // Implement your solution here
        int result = 0;
        if(A - B != 0){
            if(A % K == 0){
                result++;
            }
            if(B % K == 0){
                result++;
            }
            if(B - A == 2 && (A + 1) % K == 0){
                result++;
            }
        }else {
            if(A % K == 0){
                result++;
            }
        }
        if((B - A - 1) % 2 == 1){
            result++;
        }
        result = result + ((B - A - 1) / K);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(11,346,17));
    }

}
