package com.coding.test.aop;

import com.coding.test.aspect.PerfLogging;
import org.springframework.stereotype.Component;

@Component
public class SimpleServiceEvent implements EventService{
    @Override
    @PerfLogging
    public void created() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("created");
    }

    @Override
    @PerfLogging
    public void operation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("operation");

    }

    @Override
    public void deleted() {
        System.out.println("deleted");
    }
}
