package Scheduler;


public class Scheduler {


    public static void main(String args[])throws InterruptedException {
        String message[] = {
                "Start learning Java!",
                "Hey, START LEARNING JAVA!!!",
                "What? You still not started? Let's START!!!",
                "Ok, forget about JAVA :)"
        };

        for (int i = 0; i < message.length; i++) {
            Thread.sleep(5000);
            System.out.println(message[i]);
        }
    }

}
