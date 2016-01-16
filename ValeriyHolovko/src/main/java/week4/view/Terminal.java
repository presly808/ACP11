package week4.view;

import week4.controller.BashCommandController;
import week4.controller.IBashCommandController;

import java.io.File;
import java.util.*;

/**
 * Created by 1 on 14.01.2016.
 */
public class Terminal {


    Scanner in = new Scanner(System.in);
    BashCommandController bashCommandController = new BashCommandController();

    public Terminal() {
        run();
    }

    private void run(){

        while(true){

            System.out.println(bashCommandController.getCurrentPath().getAbsolutePath() + ">>");

            String str = in.nextLine();

            try {
                bashCommandController.run(str);
            } catch (NullPointerException e1){
                System.out.println("ERROR: No such a command found!");
            } catch (NoSuchElementException e2){
                System.out.println("ERROR: Wrong argument!");
            }
        }

    }


}
