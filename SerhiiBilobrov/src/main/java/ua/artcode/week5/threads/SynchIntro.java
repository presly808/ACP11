package ua.artcode.week5.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by serhii on 10.01.16.
 */
public class SynchIntro {


    public static void main(String[] args) {

        DataContainer dataContainer = new DataContainer();

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 50; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        dataContainer.test();
                    }
                }
            });
        }


        executorService.shutdown();

        while(!executorService.isTerminated()){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(dataContainer.value);

    }

    static class DataContainer {

        private int value;
        private Object monitor = new Object();// access key

        public void test(){
            synchronized (monitor){ // monitor is 'this'
                value = value + 1;
            }
        }

        public synchronized void synchMethod(){ // this monitor

        }

        public static synchronized void syncStatMethod(){ // this monitor

        }

        public static void syncStatMethod2(){ // this monitor
            synchronized (DataContainer.class){

            }
        }


    }

}

