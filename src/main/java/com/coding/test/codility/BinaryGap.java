package com.coding.test.codility;

public class BinaryGap {

    public static int solution(int N) {
        // Implement your solution here
        String binaryString = Integer.toBinaryString(N);
        String[] splitOne = binaryString.split("1");
        String[] split = binaryString.split("");

        int max = 0;
        if(split[split.length - 1 ].equals("1")){
            for(String numStr : splitOne){
                max = Math.max(max, numStr.length());
            }
        }


        if(split[split.length - 1 ].equals("0")){
            for(int i = 0 ; i < splitOne.length - 1; i ++){
                max = Math.max(max, splitOne[i].length());
            }
        }

        return max;
    }

    public static void main(String[] args) {
        solution(42);

    }
}
