package console.controller;

import console.utils.*;
import console.model.*;
import console.view.*;

import java.io.IOException;

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

        // TODO parseUserCommand -> route command throw reflection call;

        //System.out.println( userCommand );
        for(Command c : this.currentState.getCommands()) {
            if (c.getName().equals(userCommand)) {
                // TODO return (refl call method doExec from class c)
                System.out.println(ReflectionUtils.getTypeInfo(c));
                //String[] args = {"param","value"};
                Integer ii = 5;
                ReflectionUtils.callMethod(c, "doExec",ii);
                return;
            }
        }

        ConsoleRun.runExec(userCommand);

        askCommand();
    }

 /*   public void testCommandsAccess() {
        for(Command c: currentState.getCommands()){
            System.out.println(c.getName());
        }
    } */
}
