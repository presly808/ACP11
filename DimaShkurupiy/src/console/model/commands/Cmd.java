package console.model.commands;

import console.model.Command;
import console.model.CurrentState;
import console.model.ICommandPlugin;
import console.utils.ConsoleRun;

import java.io.IOException;
import java.util.Arrays;

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

    public String doExec(String cName, String[] args) {
        //System.out.println("cName:" + cName);
        //System.out.println("args :" + Arrays.toString(args));
        try {
            return ConsoleRun.runExec( cName, args );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }
}
