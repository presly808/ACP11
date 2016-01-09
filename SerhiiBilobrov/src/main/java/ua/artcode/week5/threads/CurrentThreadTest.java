package ua.artcode.week5.threads;

import java.util.Date;

/**
 * Created by serhii on 09.01.16.
 */
public class CurrentThreadTest {


    public static void main(String[] args) { // Main Thread

        // NEW
        MyMonitorThread monitorThread = new MyMonitorThread(Thread.currentThread());
        monitorThread.start();
        // RUNNABLE


        for (int i = 0; i < 10; i++) {
            // main
            Thread current = Thread.currentThread();
            try {
               /* System.out.printf("id %s, name %s, state %s\n",*/
               /*         current.getId(), current.getName(), current.getState());*/
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("%1$tM - %1$tS\n", new Date());
        }


        monitorThread.interrupt();
    }

}

// declare class,
// override run,
// start
class MyMonitorThread extends Thread {

    private Thread subject;

    public MyMonitorThread(Thread subject) {
        this.subject = subject;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) { // flag boolean

            try {
                Thread.sleep(99999);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            System.err.printf("id %s, name %s, state %s\n",
                    subject.getId(), subject.getName(), subject.getState());
        }
    }


}
