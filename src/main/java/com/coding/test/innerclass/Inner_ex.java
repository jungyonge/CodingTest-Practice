package com.coding.test.innerclass;

class Inner {
    int y = 20;

    public void print() {
        System.out.println("Anonymous class");
    }
}

public class Inner_ex {
    public static void main(String[] args) {
        final int x = 10; //내부 클래스에서 사용하기 위해 final로 선언

        Inner in = new Inner() {
            public void print() {
                System.out.println("overriding");
                System.out.println(x);
                System.out.println(y);
            }

            public void printX() {
                //익명 클래스 안에서 메서드를 생성하여 사용 가능
                System.out.println("Method 추가");
            }
        };

        in.print(); //익명클래스 안에서 생성된 메서드는 밖에서 사용 불가능
    }
}
