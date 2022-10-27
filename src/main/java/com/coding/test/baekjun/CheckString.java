package com.coding.test.baekjun;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strArr = scanner.next().toUpperCase().split("");
        HashMap<String, Integer> strMap = new HashMap();

        int maxNum = 0;
        String maxStr = "?";
        for(String str : strArr){
            strMap.put(str, strMap.getOrDefault(str, 0) + 1);
        }

        for( Map.Entry<String, Integer> entry : strMap.entrySet() ){
            String strKey = entry.getKey();
            int strValue = entry.getValue();
            if(strValue > maxNum){
                maxNum = strValue;
                maxStr = strKey;
            }else if (strValue == maxNum){
                maxStr = "?";
            }
        }

        System.out.println(maxStr);

    }
}
