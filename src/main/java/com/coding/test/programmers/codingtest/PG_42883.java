package com.coding.test.programmers.codingtest;

public class PG_42883 {

    static boolean[] visited;
    static String[] checkNumArr;
    static String[] numArr;
    static int K;
    static int MAX = Integer.MIN_VALUE;

    public static String solution(String number, int k) {
        String answer = "";
        visited = new boolean[number.length()];
        numArr = number.split("");
        K = number.length() - k;
        checkNumArr = new String[K];

        dfs(0,0);
        return String.valueOf(MAX);
    }

    static void dfs(int depth, int startAt){
        if(depth == K){
            StringBuilder sb= new StringBuilder();
            for(int i = 0 ; i < K; i++){
                sb.append(checkNumArr[i]);
            }
            MAX = Math.max(MAX,Integer.parseInt(sb.toString()));
            return;
        }

        for(int i = startAt ; i < numArr.length; i++ ){
            if(!visited[i]){
                visited[i] = true;

                if(startAt < K - depth && depth != 0 && Integer.parseInt(numArr[depth - 1]) < Integer.parseInt(numArr[i])){
                    checkNumArr[depth- 1] = numArr[i];
                    dfs(depth,i + 1);
                }else {
                    checkNumArr[depth] = numArr[i];
                    dfs(depth + 1,i + 1);
                }
                visited[i] = false;
            }

        }
    }

//    public static  String solution(String number, int k) {
//        StringBuilder answer = new StringBuilder("");
//        int len = number.length() - k;
//        int start = 0;
//
//        while(start < number.length() && answer.length() != len) {
//            int leftNum = k + answer.length() + 1;
//            int max = 0;
//            for (int j = start; j < leftNum; j++) {
//                if (max < number.charAt(j) - '0') {
//                    max = number.charAt(j) - '0';
//                    start = j + 1;
//                }
//            }
//            answer.append(Integer.toString(max));
//        }
//        return answer.toString();
//    }


    public static void main(String[] args) {
        solution("4177252841", 4);

    }

}
