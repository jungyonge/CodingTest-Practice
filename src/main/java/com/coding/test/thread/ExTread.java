package com.coding.test.thread;

public class ExTread extends Thread{
    private int[] temp;
    public ExTread(String threadname){
        super(threadname);
        temp = new int[10];

        for(int start=0;start<temp.length;start++){
            temp[start]=start;
        }
    }

    public void run(){
        for(int start:temp){
            try {
                Thread.sleep(1000);

            } catch (InterruptedException ie) {
                ie.printStackTrace();
                // TODO: handle exception
            }
            System.out.println("스레드이름:"+currentThread().getName());
            System.out.println("temp value :"+start);
        }
    }
}
