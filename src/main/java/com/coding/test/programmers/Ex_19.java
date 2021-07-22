package com.coding.test.programmers;

public class Ex_19 {

    static int cnt = 0;
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[target.length()];
        String[] targetArr = target.split("");
        dfs(begin,targetArr,words,visited);
        if(cnt == begin.length()){
            return cnt;
        }else {
            return 0;
        }
    }

    static boolean[] dfs(String begin, String[] targetArr, String[] words, boolean[] visited){

        for(String word : words){
            String[] wordArr = word.split("");
            for(int i = 0 ; i< wordArr.length ; i++ ){
                for(int j = 0 ; j < targetArr.length ; j ++){
                    System.out.println("wordArr : " + wordArr[i]);
                    System.out.println("targetArr : " + targetArr[j]);
                    System.out.println("visited : " + visited[j]);
                    if(wordArr[i].equals(targetArr[j])  && !visited[j]){
                        visited[j] = true;
                        cnt++;
                        System.out.println(cnt);
                        return dfs(begin,targetArr,words,visited);
                    }
                }
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        solution(begin,target,words);
    }
}
