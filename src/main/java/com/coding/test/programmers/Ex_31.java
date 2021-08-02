package com.coding.test.programmers;

import java.util.ArrayList;

public class Ex_31 {

    public static int solution(int num) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();		//값을 더해주기 위한 빈 문자열 선언
        ArrayList<String> tempArr = new ArrayList();
        while (num > 0) {
            tempArr.add(String.valueOf((num % 3)));
            num /= 3;		//다음 턴을 위해 num을 2로 나눠준다.
        }
        for(int i = 0 ; i < tempArr.size(); i ++){
            sb.append(tempArr.get(i));
        }
        answer = Integer.parseInt(sb.toString(),3);
        System.out.println(answer);
        return answer;
    }


    public static void main(String[] args) {
        int num = 45;
        solution(num);
    }

}
