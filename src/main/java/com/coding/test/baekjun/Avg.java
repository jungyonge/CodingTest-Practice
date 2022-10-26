package com.coding.test.baekjun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Avg {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> point = new ArrayList<>();
        int countSub = scanner.nextInt();
        for(int i = 0 ; i < countSub; i++){
            point.add(scanner.nextInt());
        }
        Collections.sort(point, Collections.reverseOrder());

        double maxSub = point.get(0);
        double sum = 0;

        for(int i = 0 ; i < point.size(); i++ ){
            sum = sum + (point.get(i) / maxSub * 100);
        }

        System.out.println(sum / countSub);
    }
}
