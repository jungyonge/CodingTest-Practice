package com.coding.test.programmers.test;

public class Ex_37 {
    public static int solution(String s) {
        int answer = s.length();
        StringBuffer sb = new StringBuffer();
        int cnt = 1;
        for(int i = 1 ; i <= s.length()/2   ; i ++){
            String startWord = s.substring(0, i );
            System.out.println(startWord);
            for(int j = 1 ; j < s.length() ; j ++) {
                if(i * j + i > s.length()){
                    sb.append(s.substring(i*j));
                    break;
                }
                String compareWord = s.substring(i * j,i * j + i);
                if(startWord.equals(compareWord)){
                    cnt++;
                }else {
                    if(cnt == 1){
                        sb.append(startWord);
                    }else {
                        sb.append(cnt);
                        sb.append(startWord);
                    }
                    startWord = s.substring(i * j,i * j + i);
                    cnt = 1;
                }
            }
            if(cnt == 1){
                sb.append(startWord);
            }else {
                sb.append(cnt);
                sb.append(startWord);
            }
            if(answer > sb.toString().length()){
                answer = sb.toString().length();
            }
            cnt = 1;
            sb = new StringBuffer();
        }
        return answer;
    }

    public static void main(String[] args) {
        String s= "xababcdcdababcdcd";
        solution(s);
    }
}
