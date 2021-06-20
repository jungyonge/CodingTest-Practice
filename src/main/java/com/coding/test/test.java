package com.coding.test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class test {

    public int solution(int[] cards) {
        int answer = 0;
        List<Integer> playerDeck = new ArrayList<>();
        List<Integer> dealerDeck = new ArrayList<>();
        int visibleDealerCard = 0;
        int playerSum = 0;
        int dealerSum = 0;
        int playerGap = 0;
        int dealerGap = 0;

        while (true) {

            for (int i = 0; i < cards.length; i++) {
                int turn = i % 2;
                if (turn == 0) {
                    playerDeck.add(cards[i]);
                } else {
                    playerDeck.add(cards[i]);
                }

                if(i == 3) {
                    visibleDealerCard = cards[3];
                }

                if (i >= 3) {

                    while (true) {
                        playerSum = 0;
                        for(int cardNum : playerDeck){
                            playerSum += cardNum;
                        }
                        if (playerSum == 21) {
                            break;
                        }
                    }
                }
            }

            for(int cardNum : dealerDeck){
                dealerSum += cardNum;
            }

            playerGap = 21 - playerSum;
            dealerGap = 21 - dealerSum;
            if(dealerGap > playerGap){
                if(playerSum == 21){
                    answer = 3;
                }
            }

            break;
        }

        return answer;
    }
//
//    private static boolean checkMore(List<Integer> deck, int visibleDealerCard){
//        int checkSum = sumDeck(deck);
//        if(checkSum == 21){
//            return Boolean.FALSE;
//        }
//        if(checkSum < 21){
//
//        }
//    }
    public static int checkNum(int cardNum, List<Integer> deck) {
        int result = 0;

        int sumDeck = sumDeck(deck);
        // 뽑은 카드의 번호가 '1'이면 'A'로 변환
        if (cardNum == 1 && sumDeck + 11 > 21) {
            result = 1;
        } else if (cardNum == 1 && sumDeck + 11 <= 21){
            result = 11;
        }
        // 카드 번호가 '11' 이상이면 'J, Q, K'로 변환
        if (cardNum > 10) {
          result = 10;
        }
        // 일반 숫자면 변환 없음
        else {
            if (cardNum > 1 && cardNum <= 10) {
                result = cardNum;
            }
        }
        return result;
    }

    private static int sumDeck(List<Integer> deck){
        int sumDeck = 0;
        for(int cardNum : deck){
            sumDeck += cardNum;
        }
        return sumDeck;
    }


    public int[] solution2(int[] ball, int[] order) {

        Stack<Integer> ballOriStack = new Stack<>();
        Stack<Integer> ballRevStack = new Stack<>();
        Queue<Integer> orderQueue = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        Queue<Integer> proQueue = new LinkedList<>();
        boolean proFalse = false;
        for(int i = 0 ; i < ball.length ; i++){
            ballOriStack.push(ball[i]);
        }

        for(int i = ball.length - 1  ; 0 <= i ; i--){
            ballRevStack.push(ball[i]);
        }

        for(int i = 0 ; i < order.length ; i++){
            orderQueue.add(order[i]);
        }

        while (true){
            int orderNum = 0;
            int ballOriNum = 0;
            int ballRevNum = 0;


            if(ballOriStack.size() != 0){
                ballOriNum = ballOriStack.pop();
            }
            if(ballRevStack.size() != 0){
                ballRevNum = ballRevStack.pop();
            }

            if(proQueue.size() == 0 && proFalse) {
                if(orderQueue.size() != 0){
                    orderNum = orderQueue.poll();
                }
                if(ballOriNum == orderNum){
                    resultList.add(ballOriNum);
                    ballRevStack.push(ballRevNum);
                }else if (ballRevNum == orderNum){
                    resultList.add(ballRevNum);
                    ballOriStack.push(ballOriNum);
                }else {
                    proQueue.add(orderNum);
                    ballOriStack.push(ballOriNum);
                    ballRevStack.push(ballRevNum);
                    proFalse = false;
                }
            }else {
                for(int i = 0 ; i < proQueue.size(); i ++){
                    int proNum = 0;
                    if(proQueue.size() != 0){
                        proNum = proQueue.poll();
                    }
                    if(ballOriNum == proNum){
                        resultList.add(ballOriNum);
                        ballRevStack.push(ballRevNum);
                    }else if (ballRevNum == proNum){
                        resultList.add(ballRevNum);
                        ballOriStack.push(ballOriNum);
                    }else {
                        proQueue.add(proNum);
                        ballOriStack.push(ballOriNum);
                        ballRevStack.push(ballRevNum);
                        proFalse = true;
                    }
                }
            }
            if(resultList.size() == order.length){
                break;
            }
        }

        int[] answer = new int[order.length];
        int size=0;
        for(Integer temp : resultList){
            answer[size++] = temp;
        }
        return answer;

    }



    public static void main(String[] args) {
//        int[][] v = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
        int[] v = {1, 2, 3, 4, 5, 6};
        int[] v2 = {6, 2, 5, 1, 4, 3};



//        int v2 = 73423325;
        test test = new test();
//        test.solution(v);
        test.solution2(v,v2);
    }
}

