package ua.artcode.week5.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 09.01.16.
 */
public class ProducerConsumerPattern {


    public static void main(String[] args) {
        DataBuffer buffer = new DataBuffer();
        List<Thread> threadList = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Producer(buffer));
            threadList.add(thread);
            thread.start();
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

        private int data;


        public synchronized void inc(){
            data++;
        }

        public void decr(){
            data--;
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
                //System.out.println(Thread.currentThread().getId() + " start adding to the buff " + dataBuffer.getData());
                dataBuffer.inc();
                //System.out.println(Thread.currentThread().getId() + " finish adding to the buff " + dataBuffer.getData());
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
            while(true){
                System.out.println(Thread.currentThread().getId() + " gets from the buff ");
                dataBuffer.decr();
            }
        }
    }


}
