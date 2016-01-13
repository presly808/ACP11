package console.view;

import console.model.CurrentState;

/**
 * Created by Dima on 13.01.2016.
 */
public abstract class View implements Runnable{
    private CurrentState currentState;
    protected String greetings = "Hello, this is the best ever command line console application. The MS-Dos and Bash console are only the childs, realy, men!\n";

    public View(CurrentState currentState) {
        this.currentState = currentState;
    }

    protected abstract void initView();

    public abstract void view();

    public abstract void showOutput(String ... str);

    public abstract String readUserInput();
}
