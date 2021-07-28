package com.coding.test.programmers;

import org.apache.tomcat.util.buf.StringUtils;

public class Ex_26 {
    public static int solution(String s) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        StringBuffer res = new StringBuffer();

        String[] strArr = s.split("");
        for (String str : strArr) {

            sb.append(str);
            if (sb.length() == 1 ) {
                String temp = sb.toString();
                boolean isNumeric =  temp.matches("[+-]?\\d*(\\.\\d+)?");
                if(isNumeric){
                    res.append(sb);
                    sb = new StringBuffer();
                }

            }
            if (sb.length() > 2) {
                String chechNum = getNum(sb.toString());
                if(!chechNum.equals("x")){
                    res.append(chechNum);
                    sb = new StringBuffer();
                }
            }
        }
        return Integer.parseInt(res.toString());
    }

    private static String getNum(String s) {
        switch (s){
            case "zero":
                return "0";
            case "one":
                return "1";
            case "two":
                return "2";
            case "three":
                return "3";
            case "four":
                return "4";
            case "five":
                return "5";
            case "six":
                return "6";
            case "seven":
                return "7";
            case "eight":
                return "8";
            case "nine":
                return "9";
            default:
                return "x";
        }
    }

    public static void main(String[] args) {
        String s = "one4seveneight";
        solution(s);
    }
}
