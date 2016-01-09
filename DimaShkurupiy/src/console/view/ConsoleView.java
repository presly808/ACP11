package console.view;

import console.model.CurrentState;

import java.util.Scanner;

/**
 * Created by Шкурупий on 08.01.2016.
 */
public class ConsoleView {
    private CurrentState currentState;

    public ConsoleView(CurrentState currentState) {
        this.currentState = currentState;
        firstStart();
    }

    private void firstStart() {
        System.out.println("Hello, this is the best ever command line console application.\n " +
                "The MS-Dos and Bash console are only the childs, realy, men!\n ");
    }

    public String view(String...str) {
        for (String s : str) {
            System.out.println(s);
        }
        System.out.print(currentState.getCurrentPath() + ">");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


}
