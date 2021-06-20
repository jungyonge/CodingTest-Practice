package com.coding.test;

import org.springframework.stereotype.Component;

@Component
public class SimpleServiceEvent implements EventService{
    @Override
    public void created() {
        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("created");
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void operation() {
        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("operation");
        System.out.println(System.currentTimeMillis() - begin);

    }

    @Override
    public void deleted() {
        System.out.println("deleted");
    }
}
