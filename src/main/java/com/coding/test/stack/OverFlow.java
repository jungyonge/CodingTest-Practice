package com.coding.test.stack;

public class OverFlow {

    public static void infinity_loop(){
        int i = 1;
        for(int j = 0 ; j < 100; j++){
            i = i + j;
            infinity_loop();
        }
    }

    public static void main(String[] args) {
        infinity_loop();
    }
}

