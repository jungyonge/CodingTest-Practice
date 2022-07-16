package com.coding.test.programmers.test;

public class Ex_19 {

//    static int cnt = 0;
//    public static int solution(String begin, String target, String[] words) {
//        int answer = 0;
//        boolean[] visited = new boolean[target.length()];
//        String[] targetArr = target.split("");
//        dfs(begin,targetArr,words,visited);
//        if(cnt == begin.length()){
//            return cnt;
//        }else {
//            return 0;
//        }
//    }
//
//    static boolean[] dfs(String begin, String[] targetArr, String[] words, boolean[] visited){
//
//        for(String word : words){
//            String[] wordArr = word.split("");
//            for(int i = 0 ; i< wordArr.length ; i++ ){
//                for(int j = 0 ; j < targetArr.length ; j ++){
//                    System.out.println("wordArr : " + wordArr[i]);
//                    System.out.println("targetArr : " + targetArr[j]);
//                    System.out.println("visited : " + visited[j]);
//                    if(wordArr[i].equals(targetArr[j])  && !visited[j]){
//                        visited[j] = true;
//                        cnt++;
//                        System.out.println(cnt);
//                        return dfs(begin,targetArr,words,visited);
//                    }
//                }
//            }
//        }
//
//        return visited;
//    }

    static boolean[] visited;
    static int answer = -1;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin,target,words,0);

        if(answer == -1){
            answer = 0;;
        }

        System.out.println(answer);
        return answer;
    }

    public void dfs(String begin, String target, String[] words, int count){
        if(begin.equals(target) ){
            System.out.println("word1 : " + begin);
            System.out.println("word2 : " + target);
            System.out.println("count : " + count);
            answer = count;
            return;
        }

        for(int i =0 ; i< words.length; i++){
//            System.out.println(Arrays.toString(visited));
            if(visited[i] == false && check(begin,words[i]) == true){
                visited[i] = true;
                dfs(words[i],target,words,count + 1);
                visited[i] = false;
            }
        }
    }

    public boolean check(String word1, String word2){
        int count = 0;
//        System.out.println("word1 : " + word1);
//        System.out.println("word2 : " + word2);
        for(int i = 0; i< word1.length(); i++){


            if(word1.charAt(i) != word2.charAt(i)){
                count++;
            }
        }

        if(count == 1){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Ex_19 ex_19 = new Ex_19();
        ex_19.solution(begin,target,words);
    }
}
