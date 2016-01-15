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

    public void askCommand(String ... res) throws IOException, InterruptedException, NoSuchMethodException {
        // TODO make different threads for user input and userCommands stack. show the results of commands and back to waiting user input
        String userCommand = this.consoleView.view(res);
        StrCmdParser parser = new StrCmdParser();
        ArrayList<String> commandResults = new ArrayList<>();

        ArrayList<UserOrder> uo = parser.parserStrCmd(userCommand);

        for (int i = 0; i < uo.size(); i++) {
            String commandName = uo.get(i).getuOrder();
            Command currentCommand = findCommandByName(commandName);
            commandResults.add((String) ReflectionUtils.callMethod(currentCommand, "doExec", commandName, uo.get(i).getuArgs()));
        }

        String[] s = commandResults.toArray(new String[commandResults.size()]);
        askCommand( s );
    }

    private Command findCommandByName(String needleName) {
        for (Command c : this.currentState.getCommands() ) {
            if ( c.getName().equals( needleName.toLowerCase() ) ) {
                return c;
            }
        }
        return findCommandByName("cmd");
    }

}
