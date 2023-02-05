package com.coding.test.goorm;

import java.util.*;

public class GR_Prepaid {


    //표준입력을 수행할 Scanner를 선언한다
    public static String[] words;
    public static Stack<String> wordStack = new Stack<>();

    public static char[] password;
    public static int password_length;
    public static int word_cnt;
    public static String result = "";

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        //초기 데이터 설정
        password_length = scanner.nextInt();
        word_cnt = scanner.nextInt();
        words = new String[word_cnt];

        scanner.nextLine();
        password = scanner.nextLine().toCharArray();

        for(int i = 0 ; i < word_cnt; i ++){
            words[i] = scanner.nextLine();
        }

        // 사전 순으로 단어 정렬
        Arrays.sort(words);

        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int find_password_index){
        //만약 현재 비밀번호 길이와 만들어진 비밀번호의 길이가 같으면 비교
        if(find_password_index == password_length){
            StringBuilder sb = new StringBuilder();
            for (String s : wordStack) {
                sb.append(s);
            }
            //비어 있거나 기존 생성된 password 보다 사전순으로 앞서면 변경
            if(result.equals("") || result.compareTo(sb.toString()) > 0){
                result = sb.toString();
            }
            return;
        }

        for(int i = 0; i < word_cnt; i ++){
            if(find_password_index + words[i].length() <= password_length){
                char[] compareWord = words[i].toCharArray();
                boolean check = true;
                for(int j = 0 ; j < compareWord.length; j++){

                    // ?일 경우 pass
                    if( password[find_password_index + j]  == 63){
                        continue;
                    }
                    if(compareWord[j] != password[find_password_index + j]){
                        check = false;
                        break;
                    }
                }
                if(check){
                    find_password_index = find_password_index + words[i].length();
                    wordStack.push(words[i]);
                    dfs(find_password_index);
                    if(!wordStack.isEmpty()){
                        find_password_index = find_password_index - words[i].length();
                        wordStack.pop();
                    }
                }

            }
        }
    }
}
