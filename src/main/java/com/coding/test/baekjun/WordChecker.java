package com.coding.test.baekjun;

import java.util.HashMap;
import java.util.Scanner;

public class WordChecker {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        boolean checkDup = false;
        int wordCount = scanner.nextInt();
        for(int i = 0 ; i < wordCount ; i++){
            String[] strArr = scanner.next().split("");
            String checkStr = "";
            HashMap<String, Boolean> check = new HashMap<>();
            for(String str : strArr){
                if(!checkStr.equals(str)){
                    checkStr = str;
                    if(!check.containsKey(str)) {
                        check.put(str, true);
                    }else if(check.containsKey(str) && check.get(str)){
                        checkDup = true;
                        break;
                    }
                }
            }
            if(!checkDup){
                sum++;
            }
            checkDup = false;


        }
        System.out.println(sum);
    }
}
