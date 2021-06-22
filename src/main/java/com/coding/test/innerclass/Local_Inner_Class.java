package com.coding.test.innerclass;

public class Local_Inner_Class {
    public static void main(String[] args) {
        //정적 내부 클래스 선언방법

        int x = 10;

        class Inner{
            int y = 20;
        }

        Inner in = new Inner();

        System.out.println(x);
        System.out.println(in.y);
    }
}
