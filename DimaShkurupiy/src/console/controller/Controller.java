package console.controller;

import console.utils.*;
import console.model.*;
import console.view.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Шкурупий on 08.01.2016.
 */
public class Controller {
    private CurrentState currentState;
    private ConsoleView consoleView;
    //private Command currentCommand;

    public Controller() throws Exception {
        this.currentState = new CurrentState();
        this.consoleView = new ConsoleView(this.currentState);
        askCommand();
    }

    public void askCommand() throws IOException, InterruptedException, NoSuchMethodException {
        // TODO make different threads for user input and userCommands stack. show the results of commands and back to waiting user input
        String userCommand = this.consoleView.view();
        StrCmdParser parser = new StrCmdParser();

        ArrayList<UserOrder> uo = parser.parserStrCmd(userCommand);

        for (int i = 0; i < uo.size(); i++) {
            String commandName = uo.get(i).getuOrder();
            for(Command c : this.currentState.getCommands()) {
                if( commandName.equals(c.getName()) ) {
// TODO add multiThreading  !!!
                    ReflectionUtils.callMethod(c, "doExec", uo.get(i).getuArgs());
                    continue;
                }
            }
// TODO Continue issue - this code always run. idea - run ext command throw the plugin class - it seems to be able make multithreading solution
            ConsoleRun.runExec( commandName, uo.get(i).getuArgs() );
        }

        askCommand();
    }

}
