package com.coding.test.thread;

public class ImpRunable implements Runnable{
    private int[] temp;

    public ImpRunable(){
        temp = new int[10];

        for(int start=0;start<temp.length;start++){
            temp[start]=start;
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int start:temp){
            try {
                Thread.sleep(1000);

            } catch (InterruptedException ie) {
                ie.printStackTrace();
                // TODO: handle exception
            }

            System.out.println("스레드이름:"+Thread.currentThread().getName());
            System.out.println("temp value :"+start);
        }
    }

    public static void main(String[] args) {
        ExTread st = new ExTread("첫번째");
        ExTread st2= new ExTread("두번째");

        st.start();
        st2.start();

//        ImpRunable ct = new ImpRunable();
//        Thread t = new Thread(ct,"첫번째");
//        Thread t2 = new Thread(ct,"두번");
//
//        t.start();
//        t2.start();
    }
}


