package com.coding.test.baekjun;

import java.util.Scanner;

public class Palindrome {


    public static int recursion(String s, int l, int r, int cnt) {
        if (l >= r) {
            System.out.println(1 + " " + cnt);
            return 1;
        } else if (s.charAt(l) != s.charAt(r)) {
            System.out.println(0 + " " + cnt);
            return 0;
        } else {
            cnt ++;
            return recursion(s, l + 1, r - 1, cnt);
        }
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1, 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        for(int i = 0 ; i < cnt ; i ++){
            isPalindrome(scanner.next());
        }
    }


}
