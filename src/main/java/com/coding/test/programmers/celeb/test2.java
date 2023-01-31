package com.coding.test.programmers.celeb;

import java.util.HashMap;

public class test2 {

    public static int solution(int[] cards1, int[] cards2) {
        HashMap<Integer, Integer> allCardDeck = new HashMap<>();
        HashMap<Integer, Integer> cardOneDeck = new HashMap<>();
        HashMap<Integer, Integer> cardTwoDeck = new HashMap<>();
        int allDeckMaxCard = 0;
        int cardOneDeckMaxCard = 0;
        int cardTwoDeckMaxCard = 0;

        for(int i = 0 ; i < cards1.length ; i ++){
            allCardDeck.put(cards1[i], allCardDeck.getOrDefault(cards1[i], 0) + 1);
            allCardDeck.put(cards2[i], allCardDeck.getOrDefault(cards2[i], 0) + 1);
            allDeckMaxCard = Math.max(allDeckMaxCard, allCardDeck.get(cards1[i]));
            allDeckMaxCard = Math.max(allDeckMaxCard, allCardDeck.get(cards2[i]));


            cardOneDeck.put(cards1[i], cardOneDeck.getOrDefault(cards1[i], 0) + 1);
            cardOneDeckMaxCard =  Math.max(cardOneDeckMaxCard, cardOneDeck.get(cards1[i]));
            cardTwoDeck.put(cards2[i], cardTwoDeck.getOrDefault(cards2[i], 0) + 1);
            cardTwoDeckMaxCard =  Math.max(cardTwoDeckMaxCard, cardTwoDeck.get(cards2[i]));

        }

        int answer = -1;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,2,3,3,3}, new int[]{1,1,2,3,3,4}));
    }
}
