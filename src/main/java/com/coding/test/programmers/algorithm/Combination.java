package com.coding.test.programmers.algorithm;

public class Combination {


    public void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr) {
        if(r == 0) {
            // 다 뽑았을 때
            for(int i=0; i<index; i++)
                System.out.print(arr[combArr[i]] + " ");
            System.out.println();
        } else if (target == n)
            return;
            //r개를 다 못뽑았는데 arr의 모든 원소를 다 검사했을 때, 실패 -> 아무것도 안하고 끝난다.
        else {
            combArr[index] = target;
            doCombination(combArr, n, r-1, index+1, target+1, arr); // (i) 원소를 뽑는 경우
            doCombination(combArr, n, r, index, target+1, arr); // (ii) 원소를 안뽑는 경우
        }
    }

    public static void main(String[] args) {
        Combination ex = new Combination();
        int[] arr = {1, 3, 5, 7, 9};
        int n = arr.length;
        int r = 3;
        // 크기가 5인 수열 arr에서 r인 3r개를 뽑은 경우를 출력한다.
        int[] combArr = new int[n]; // 뽑은 원소의 인덱스를 저장하는 배열

        ex.doCombination(combArr, n, r, 0, 0, arr);

    }

}
