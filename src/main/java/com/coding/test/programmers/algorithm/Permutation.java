package com.coding.test.programmers.algorithm;

public class Permutation {

    public void doPermutation(int[] arr, int startIdx) {
        int length = arr.length;
        if(startIdx == length - 1) {
            for(int n: arr)
                System.out.print(n + " ");
            System.out.println();
            return;
        }

        for(int i = startIdx; i < length; i++) {
            swap(arr, startIdx, i);
            doPermutation(arr, startIdx + 1);
            swap(arr, startIdx, i);
        }
    }

    public void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    public static void main(String[] args) {
        Permutation ex = new Permutation();
        int[] arr = {1, 2, 3, 4};
        // arr 배열 자체를 메소드에서 정렬한다.
        ex.doPermutation(arr, 0);

    }

}
