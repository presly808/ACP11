package console.controller;

import console.utils.*;
import console.model.*;
import console.view.*;

import java.io.IOException;
import java.util.ArrayList;

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
        //testCommandsAccess();
        askCommand();
    }

    public void askCommand() throws IOException, InterruptedException, NoSuchMethodException {
        String userCommand = this.consoleView.view();
        StrCmdParser parser = new StrCmdParser();

        // TODO parseUserCommand -> route command throw reflection call;
        ArrayList<UserOrder> uo = parser.parserStrCmd(userCommand);

        boolean isCommandExternal = true;

        for (int i = 0; i < uo.size(); i++) {
            String commandName = uo.get(i).getuOrder();
            for(Command c : this.currentState.getCommands()) {
                if( commandName.equals(c.getName()) ) {
                    // TODO return (refl call method doExec from class c)
                    ReflectionUtils.callMethod(c, "doExec", uo.get(i).getuArgs());
                    //ReflectionUtils.callMethod(c, "doExec");
                    //ReflectionUtils.callMethod(c, "testReflCall", uo.get(i).getuArgs());
                    continue;
                }
            }

            ConsoleRun.runExec( commandName, uo.get(i).getuArgs() );
        }

        askCommand();
    }

 /*   public void testCommandsAccess() {
        for(Command c: currentState.getCommands()){
            System.out.println(c.getName());
        }
    } */
}
