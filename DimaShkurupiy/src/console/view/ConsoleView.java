package console.view;

import console.model.CurrentState;

import java.util.Scanner;

/**
 * Created by Шкурупий on 08.01.2016.
 */
public class ConsoleView  implements IView, Runnable{
    private CurrentState currentState;
    protected String greetings = "Hello, this is the best ever command line console application. The MS-Dos and Bash console are only the childs, realy, men!\n";

    public ConsoleView(CurrentState currentState) {
        this.currentState = currentState;
        initView();
    }

    @Override
    public void initView() {
        System.out.println(greetings);
    }
/*
    @Override
    public void view() {

    }
*/
    @Override
    public void showOutput(String... str) {

    }

    @Override
    public String readUserInput() {
        return null;
    }

    @Override
    public void run() {

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
