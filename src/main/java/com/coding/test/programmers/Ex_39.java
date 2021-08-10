package com.coding.test.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Ex_39 {
    public static int solution(String s) {
        int answer = -1;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        String[] strArr = s.split("");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strArr));
        while (true){
            int sizeCh = arrayList.size();
            for(int i = 0 ; i < arrayList.size() - 1 ; i++){
                if(arrayList.get(i).equals(arrayList.get(i + 1))){
                    arrayList.remove(i);
                    arrayList.remove(i);
                    break;
                }
            }
            if(sizeCh == arrayList.size()){
                answer = 0;
                break;
            }
            if(arrayList.size() == 0){
                answer = 1;
                break;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static int solution2(String s) {
        Stack<String> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                stack.push(String.valueOf(s.charAt(i)));
            }else{
                String lastVal = stack.peek();
                String currVal = String.valueOf(s.charAt(i));
                if(!lastVal.equals(currVal)){
                    stack.push(currVal);
                }else{
                    stack.pop();
                }
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        String s = "cdcd";
        solution2(s);
    }
}
