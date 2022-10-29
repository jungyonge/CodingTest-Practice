package com.coding.test.baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class PositionPress {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int cnt = scanner.nextInt();
//        ArrayList<Integer> numSet = new ArrayList<>();
//        Integer[] numArr = new Integer[cnt];
//        for(int i = 0 ; i < cnt ; i++){
//            int num = scanner.nextInt();;
//            if(!numSet.contains(num)){
//                numSet.add(num);
//            }
//            numArr[i] = num;
//        }
//        StringBuilder sb = new StringBuilder();
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        numSet.sort(Collections.reverseOrder());
//
//        int count = 0;
//        for (int i = 0; i < numArr.length; i++) {
//            if (!map.containsKey(numArr[i])) {
//                map.put(numArr[i], count++);
//            }
//        }
//
//        for(int i : numArr){
//            int sum = 0;
//            if(map.containsKey(i)){
//                sum = map.get(i);
//            }else {
//                int temp = numSet.size() - numSet.indexOf(i) - 1;
//                map.put(i ,temp);
//                sum = temp;
//            }
//
//            sb.append(sum).append(" ");
//        }
//        System.out.println(sb.toString().substring(0,sb.toString().length() - 1));
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = new Integer(br.readLine());
        int[] arr = new int[N];
        int[] arrClone;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arrClone = arr.clone();

        Arrays.sort(arrClone);

        for (int i = 0; i < arrClone.length; i++) {
            if (!map.containsKey(arrClone[i])) {
                map.put(arrClone[i], count++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}
