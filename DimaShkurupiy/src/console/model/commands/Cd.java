package console.model.commands;

import console.model.Command;
import console.model.CurrentState;
import console.model.ICommandPlugin;

/**
 * Created by Шкурупий on 08.01.2016.
 */
public class Cd extends Command
                    implements ICommandPlugin {

    public Cd(CurrentState currentState) {
        super.name = "cd";
        super.currentState = currentState;
        super.help = "cd (ChangeDirectory)";
    }

    public String doExec(String[] args) {
        return "OPACHKI! command " + name + " was executed " + currentState.getCurrentPath();
    }

 }
