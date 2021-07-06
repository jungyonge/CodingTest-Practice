//package com.coding.test.programmers;
//
//import java.util.ArrayList;
//
//public class Ex_5 {
//    public static int[] solution(int[] progresses, int[] speeds) {
//        ArrayList<Integer> answerList = new ArrayList<>();
//        ArrayList<Integer> arrList = new ArrayList<>();
//
//        int[] time = new int[3];
//        for (int i = 0; i < progresses.length; i++) {
//            double takes = (100.0 - (double) progresses[i]) / (double) speeds[i];
//            arrList.add((int) Math.ceil(takes));
//        }
//
//        int cnt = 1;
//        int j=0;
//        while(true){
//            if(arrList.get(j) >= arrList.get(j+1)){
//                arrList.remove(j+1);
//                cnt++;
//            }
//            else{
//                j++;
//                answerList.add(cnt);
//                cnt = 1;
//            }
//
//            if(arrList.size() -1 == answerList.size()){
//                answerList.add(cnt);
//                break;
//            }
//        }
//
//
//        // int형 배열로 변환
//        int[] answer = new int[answerList.size()];
//        for (int i = 0; i < answerList.size(); i++) {
//            answer[i] = answerList.get(i);
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        int[] progress = {93, 30, 55};
//        int[] speeds = {1, 30, 5};
//        solution(progress, speeds);
//
//    }
//}
//
//import java.util.*;
//
//class Solution {
//    public int solution(int[] priorities, int location) {
//        //answer는 내가 원하는 프린트의 출력 순서
//        //index는 우선순위에 맞춰 변하는 배열의 index를 표시하기 위한 변수
//        //max_change는 max_change가 0일 때는 우선순위 최대값이 변하지 않고
//        //1 일때는 우선순위를 변경시켜야 한다는 것을 표시해야하는 변수
//        int answer = 0;
//        int index = 0;
//        int max_change = 0;
//
//        ArrayList<Integer> prior = new ArrayList<Integer>();
//
//        for(int i=0; i<priorities.length; i++) {
//            prior.add(priorities[i]);
//        }
//
//        //Collections.max()를 사용하면 변하는 최대값을 찾기가 힘들어서 내림차순으로 만들어 사용하였다.
//        Collections.sort(prior);
//        Collections.reverse(prior);
//        int max = prior.get(0);
//
//        while(true){
//            //index를 돌면서 max값과 같아지면 프린트하고 그 수를 -1로 만들어준다.
//            //하나를 출력하였으므로 answer를 추가시키고 최대 우선순위를 가진 프린트가 출력되었으므로,
//            //max_change 스위치를 1로 바꿔준다.
//            if(priorities[index]==max) {
//                priorities[index] = -1;
//                answer++;
//                max_change = 1;
//            } else {
//                //index를 돌게하기 위해서 최대값이 아니라면 1씩 증가시켜주고 끝까지 간다면 0으로 만들어준다.
//                if(index==priorities.length-1) {
//                    index = 0;
//                } else {
//                    index++;
//                }
//            }
//
//            //원하는 location의 프린트가 출력되어서 -1이 된다면 break한다.
//            if(priorities[location]==-1) {
//                break;
//            }
//
//            //max_change가 1이 되면 현재의 최대 우선순위를 제거해주고 max를 바꿔준다.
//            //max_change를 0으로 다시 설정해 스위치를 꺼준다.
//            if(max_change==1) {
//                prior.remove(0);
//                max = prior.get(0);
//                max_change = 0;
//            }
//        }
//
//        return answer;
//    }
//}
