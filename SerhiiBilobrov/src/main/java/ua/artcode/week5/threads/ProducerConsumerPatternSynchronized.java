package ua.artcode.week5.threads;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerPatternSynchronized {


    public static final int MILLIS = 100;

    public static void main(String[] args) {
        DataBuffer buffer = new DataBuffer();
        buffer.setLimit(1);
        List<Thread> threadList = new ArrayList<>();


        for (int i = 0; i < 5; i++) {

            Thread producer = new Thread(new Producer(buffer));
            Thread cosumer = new Thread(new Consumer(buffer));

            threadList.add(cosumer);
            threadList.add(producer);

            producer.start();
            cosumer.start();

            //new Thread(new Consumer(buffer)).start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println(buffer.getData());
    }


    static class DataBuffer {

        private int limit;
        private int data;
        private Object monitor = new Object();



        public void inc(){
            synchronized (monitor){
                while(data >= limit){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                data++;
                monitor.notifyAll();
            }
        }

        public void decr(){
            synchronized (monitor){
                while(data == 0){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                data--;
                monitor.notifyAll();
            }
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getData() {
            return data;
        }
    }

    static class Producer implements Runnable {

        private DataBuffer dataBuffer;

        public Producer(DataBuffer dataBuffer) {
            this.dataBuffer = dataBuffer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++) {
                System.out.println(Thread.currentThread().getName() + " start adding to the buff " + dataBuffer.getData());
                dataBuffer.inc();
                System.out.println(Thread.currentThread().getName() + " finish adding to the buff " + dataBuffer.getData());

            }
        }
    }

    static class Consumer implements Runnable {

        private DataBuffer dataBuffer;

        public Consumer(DataBuffer dataBuffer) {
            this.dataBuffer = dataBuffer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++) {
                System.out.println(Thread.currentThread().getName() + " starts getting from the buff " + dataBuffer.getData());
                dataBuffer.decr();
                System.out.println(Thread.currentThread().getName() + " finish getting from the buff " + dataBuffer.getData());

           }
        }
    }


}
