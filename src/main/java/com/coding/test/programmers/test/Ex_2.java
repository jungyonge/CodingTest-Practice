package com.coding.test.programmers.test;

//https://school.programmers.co.kr/learn/courses/30/lessons/42577
//전화번호 목록
public class Ex_2 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i = 0; i < phone_book.length - 1; i++) {
            for(int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j])) {
                    answer = false;
                    return answer;
                }
                if(phone_book[j].startsWith(phone_book[i])) {
                    //마지막 배열이 접두사인지 검사하기 위한 코드
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] books = {"119", "97674223", "1195524421"};
        boolean res = solution(books);
    }
}
