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
// TODO где то в этом цикле я зациклился. утром разберусь.
        for (int i = 0; i < uo.size(); i++) {
            String commandName = uo.get(i).getuOrder();
            for(Command c : this.currentState.getCommands()) {
// TODO add multiThreading  !!!
                if( commandName.equals(c.getName()) ) {
                    commandResults.add( (String) ReflectionUtils.callMethod(c, "doExec", uo.get(i).getuArgs()) );
                } else {
                    for ( Command cm : this.currentState.getCommands() ) {
                        if( cm.getName().equals("cmd") ) {
                            String[] newArgs = new String[uo.get(i).getuArgs().length + 1];
                            newArgs[0] = commandName;
                            System.arraycopy(uo.get(i).getuArgs(),0,newArgs,1,uo.get(i).getuArgs().length);

                            commandResults.add( (String) ReflectionUtils.callMethod(cm, "doExec",newArgs) );
                            continue;
                        }
                    }
                }
            }
// TODO Continue issue - this code always run. idea - run ext command throw the plugin class - it seems to be able make multithreading solution
            //System.out.println( ConsoleRun.runExec( commandName, uo.get(i).getuArgs() ) );
        }
        String[] s = commandResults.toArray(new String[commandResults.size()]);
        askCommand( s );
    }

}
