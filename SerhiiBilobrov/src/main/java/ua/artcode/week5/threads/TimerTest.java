package ua.artcode.week5.threads;

import java.util.Date;

/**
 * Created by serhii on 09.01.16.
 */
public class TimerTest {


    public static final int INTERVAL = 500;

    public static void main(String[] args) {
        long last = System.currentTimeMillis();
        while(true){
            if(System.currentTimeMillis() - last >= INTERVAL){
                System.out.printf("%1$tM - %1$tS\n", new Date());
                last = System.currentTimeMillis();
            }
        }
    }


}
