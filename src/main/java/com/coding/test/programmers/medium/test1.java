package com.coding.test.programmers.medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Qualifier;

public class test1 {

    public static String solution(String encrypted_text, String key, int rotation) {

        Deque<String> queue = new LinkedList<>(Arrays.asList(encrypted_text.split("")));
        char[] key_array = key.toCharArray();
        char[] decrypted_array = new char[encrypted_text.length()];

        for (int i = 0; i < rotation; i++) {
            queue.addLast(queue.pollFirst());
        }

        int i = 0;
        while (!queue.isEmpty()) {
            char encrypted = queue.pollFirst().charAt(0);
            int move = key_array[i] - 96;
            char temp = (char) (encrypted - move);
            if (encrypted - move < 97) {
                temp = (char) (encrypted - move + 26);
            }
            decrypted_array[i] = temp;
            i++;
        }

        StringBuilder answer = new StringBuilder();
        for (char decrypted_text : decrypted_array) {
            answer.append(decrypted_text);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("bac", "dbc", 0));
    }
}
