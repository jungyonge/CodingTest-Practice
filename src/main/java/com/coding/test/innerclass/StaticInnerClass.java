package com.coding.test.innerclass;


class Outer {

    int x = 10;
    static int y = 20;

    static class Inner{ //내부 클래스
        int z = 30;

        public void print() {
            // System.out.println(x); // outer클래스의 인스턴스 변수는 사용 불가능
            System.out.println(y);
            System.out.println(z);
        }

    }
}

public class StaticInnerClass {
    public static void main(String[] args) {
        //정적 내부 클래스 선언방법
        Outer.Inner inner = new Outer.Inner();

        inner.print();
    }
}