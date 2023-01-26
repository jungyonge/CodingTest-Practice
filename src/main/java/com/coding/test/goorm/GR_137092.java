package com.coding.test.goorm;



import java.io.*;
        import java.lang.*;
        import java.util.*;


public class GR_137092 {

    static Set<String> checkSet = new HashSet<>();

    public static void main(String[] args) throws Exception {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine().trim());
        checkSet.add("a");
        checkSet.add("e");
        checkSet.add("i");
        checkSet.add("o");
        checkSet.add("u");
        String input;

        for(int i = 0 ; i < n ; i ++)
        {
            input = reader.readLine().trim();
            String[] inputArray = input.split("");
            Stack<String> stack = new Stack<>();

            stack.push(inputArray[0]);
            for(int j = 1 ; j < inputArray.length; j ++){
                if(!checkSet.contains(inputArray[j])){
                    stack.push(inputArray[j]);
                }
                if(!checkSet.contains(stack.peek()) && checkSet.contains(inputArray[j])){
                    stack.push(inputArray[j]);
                }
            }

            StringBuilder sb = new StringBuilder();

            for(int s = 0  ; s < stack.size(); s ++){
                sb.append(stack.get(s));
            }
            System.out.println(sb);

        }


        writer.flush();
        writer.close();
        reader.close();
    }




}
