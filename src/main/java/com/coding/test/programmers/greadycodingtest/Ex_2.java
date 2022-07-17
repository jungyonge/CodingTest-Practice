package com.coding.test.programmers.greadycodingtest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Ex_2 {
//    https://school.programmers.co.kr/learn/courses/30/lessons/42860
//    조이스틱

    public static int solution(String name) {
        int answer = 0;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        LinkedList<String> alphabetList = new LinkedList<>();

        for(int i = 0 ; i < alphabet.length(); i ++){
            alphabetList.add(String.valueOf(alphabet.charAt(i)));
        }

        int firstMove = 0;
        int lastMove = 0;
        int resultMove = 0;
        String nowAlphabet = "A";
        for(int i = 0 ; i < name.length(); i++){
            String targetAlphabet = String.valueOf(name.charAt(i));
            int nowPosition = alphabetList.indexOf(nowAlphabet);
            int targetPosition = alphabetList.indexOf(targetAlphabet);

            resultMove = Math.abs(nowPosition - targetPosition);
            firstMove = targetPosition + 1;
            lastMove = 26 - targetPosition ;

            System.out.println(resultMove);
            if(nowAlphabet.equals("A")){
                firstMove -= 1;
            }
            System.out.println(firstMove);

            if(resultMove > firstMove){
                resultMove = firstMove;
            }



            if(nowAlphabet.equals("Z")){
                lastMove -= 1;
            }

            System.out.println(lastMove);
            if(resultMove > lastMove){
                resultMove = lastMove;
            }

//            nowAlphabet = targetAlphabet;

            answer = answer + resultMove;
            System.out.println(targetAlphabet + " : " + resultMove);
        }
        return answer;
    }

    class Solution {
        public int solution(String name) {
            int answer = 0;
            int length = name.length();

            int index; // 다음 값들을 확인할 때 사용
            int move = length - 1; // 좌우 움직임 수를 체크

            for(int i = 0; i < name.length(); i++){
                answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

                index = i + 1;
                // 연속되는 A 갯수 확인
                while(index < length && name.charAt(index) == 'A'){
                    index++;
                }

                // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
                move = Math.min(move, i * 2 + length - index);
                // 2022년 이전 테스트 케이스만 확인하면 여기까지해도 정답처리가 되기 때문에, 이전 정답들에는 여기까지만 정리되어 있지만,
                // BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려하려면 아래의 코드가 필요합니다.
                move = Math.min(move, (length - index) * 2 + i);
            }
            return answer + move;
        }
    }

    public static void main(String[] args) {

        solution("JEROEN");
    }
}
