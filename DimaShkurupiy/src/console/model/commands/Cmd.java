package console.model.commands;

import console.model.Command;
import console.model.CurrentState;
import console.model.ICommandPlugin;
import console.utils.ConsoleRun;

import java.io.IOException;

/**
 * Created by Dima on 14.01.2016.
 */
public class Cmd extends Command
        implements ICommandPlugin {

    public Cmd(CurrentState currentState) {
        super.name = "cmd";
        super.currentState = currentState;
        super.help = "cmd (Redirecting external commands to OS cmd shell)";
    }

    public String doExec(String[] args) {
        String commandName = args[0];
        String[] newArgs = new String[args.length-1];
        System.arraycopy(newArgs,0,args,1,args.length-1);

        try {
            return ConsoleRun.runExec( commandName, newArgs );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }
}
