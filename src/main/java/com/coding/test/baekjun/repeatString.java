package com.coding.test.baekjun;

import java.util.Scanner;

public class repeatString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            if(!scanner.hasNext()){
                break;
            }
            String[] command = scanner.nextLine().split(" ");

            StringBuilder sb = new StringBuilder();

            if(command.length > 1){
                String[] strings = command[1].split("");
                for(int i = 0 ; i < strings.length; i ++){
                    for(int j = 0 ; j < Integer.parseInt(command[0]); j ++){
                        sb.append(strings[i]);
                    }
                }
            }
            System.out.println(sb.toString());
        }

    }
}
