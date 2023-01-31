package com.coding.test.programmers.celeb;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class test3 {

    static int cnt = 0;
    public static int solution(String s) {
        int answer = 0;
        String[] stringArray = s.split("");
        Stack<String> stack = new Stack<>();
        String none = "";
        LinkedList<String> makeNewStringList = new LinkedList<>(Arrays.asList(stringArray));
        none = findNone(stringArray);

        for(int i = 0 ; i < makeNewStringList.size(); i ++){
            LinkedList<String> tempStringList = (LinkedList<String>) makeNewStringList.clone();
            tempStringList.add(i, none);
            boolean check = checkVerify(tempStringList);
            if(check){
                cnt++;
            }
        }

        return cnt;
    }

    static boolean checkVerify(LinkedList<String> tempStringList){
        Stack<String> stack = new Stack<>();
        stack.push(tempStringList.get(0));

        for(int i = 1 ; i < tempStringList.size() ; i ++){
            if(stack.isEmpty()){
                stack.push(tempStringList.get(i));
                continue;
            }
            if(tempStringList.get(i).equals(")") && stack.peek().equals("(")){
                stack.pop();
                continue;
            }
            if(tempStringList.get(i).equals("}") && stack.peek().equals("{")){
                stack.pop();
                continue;

            }
            if(tempStringList.get(i).equals("]") && stack.peek().equals("[")){
                stack.pop();
                continue;
            }
            stack.push(tempStringList.get(i));
        }
        if(!stack.isEmpty()){
            return false;
        }else {
            return true;
        }

    }
    static String findNone (String[] stringArray){
        Stack<String> stack = new Stack<>();
        int[] noneArray = new int[3];
        String none = "";
        stack.push(stringArray[0]);

        for(int i = 1 ; i < stringArray.length ; i ++){
            if(stack.isEmpty()){
                stack.push(stringArray[i]);
                continue;
            }
            if(stringArray[i].equals(")") && stack.peek().equals("(")){
                stack.pop();
                continue;
            }
            if(stringArray[i].equals("}") && stack.peek().equals("{")){
                stack.pop();
                continue;

            }
            if(stringArray[i].equals("]") && stack.peek().equals("[")){
                stack.pop();
                continue;
            }
            stack.push(stringArray[i]);
        }

        for(String s : stack){
            if(s.equals("(")){
                noneArray[0] = noneArray[0] - 1;
            }
            if(s.equals(")")){
                noneArray[0] = noneArray[0] + 1;
            }
            if(s.equals("{")){
                noneArray[1] = noneArray[1] - 1;
            }
            if(s.equals("}")){
                noneArray[1] = noneArray[1] + 1;
            }
            if(s.equals("[")){
                noneArray[2] = noneArray[2] - 1;
            }
            if(s.equals("]")){
                noneArray[2] = noneArray[2] + 1;
            }
        }
        for(int i = 0 ; i < noneArray.length; i ++){
            if(noneArray[i] > 0){
                if(i == 0)
                    none = "(";
                if(i == 1)
                    none = "{";
                if(i == 2)
                    none = "[";
            }
            if(noneArray[i] < 0){
                if(i == 0)
                    none = ")";
                if(i == 1)
                    none = "}";
                if(i == 2)
                    none = "]";
            }
        }

        return none;

    }

    public static void main(String[] args) {
        System.out.println(solution("[]([[]){}"));
        System.out.println(solution("{([()]))}"));

    }
}
