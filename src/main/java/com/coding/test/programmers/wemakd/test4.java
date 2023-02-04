package com.coding.test.programmers.wemakd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test4 {

    static int MAX_LENGTH = 0;
    static Set<String> strSet = new HashSet<>();

//    public static boolean[] sol(String[] a) {
//        boolean[] answer = new boolean[a.length];
//        String[] cloneArray = a.clone();
//        Arrays.sort(cloneArray, (s1, s2) -> s2.length() - s1.length());
//        MAX_LENGTH = cloneArray[0].length();
//        dfs("a", 1);
//
//        for (int i = 0; i < a.length; i++) {
//            answer[i] = strSet.contains(a[i]);
//        }
//
//        return answer;
//    }
//
//    public static void dfs(String s, int aCount) {
//        if (strSet.contains(s)) {
//            return;
//        } else {
//            strSet.add(s);
//        }
//
//        if (s.length() > MAX_LENGTH) {
//            return;
//        }
//
//        for (int i = 0; i < 3; i++) {
//            String temp = "";
//            if (i == 0) {
//                temp = "a" + s;
//                dfs(temp, aCount + 1);
//            } else if (i == 1) {
//                temp = s + "a";
//                dfs(temp, aCount + 1);
//            } else {
//                StringBuilder sb = new StringBuilder();
//                for (int j = 0; j < aCount; j++) {
//                    sb.append("b");
//                }
//                temp = sb + s + sb;
//                dfs(temp, aCount);
//            }
//        }
//
//    }
//
//    public static int countA(String str) {
//        int count = 0;
//
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == 'a') {
//                count++;
//            }
//        }
//
//        return count;

    static boolean[] answer;
    static StringBuilder sb = new StringBuilder();
    static String target = "";


    public static boolean[] sol(String[] a) {

        answer = new boolean[a.length];

        for (int i = 0; i < a.length; i++) {
            target = a[i];
            dfs("a", "b", i);
        }

        return answer;
    }


    public static boolean check(String s){
        if(s.charAt(0) == 'a'){
            for(int i = 0 ; i< s.length(); i ++){
                if(s.charAt(0) == 'a'){


                }
            }
        }
    }
    public static void main(String[] args) {

        System.out.println(sol(new String[]{"abab", "bbaa", "bababa", "bbbabababbbaa"}));
    }
}
