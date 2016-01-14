package console.model.commands;

import console.model.Command;
import console.model.CurrentState;
import console.model.ICommandPlugin;

/**
 * Created by Шкурупий on 09.01.2016.
 */
public class Dir extends Command
                    implements ICommandPlugin {

    public Dir(CurrentState currentState) {
        super.name = "dir";
        super.currentState = currentState;
        super.help = "dir (Directory listing)";
    }

    public String doExec(String[] args) {
        return "command " + super.name + " was executed";
    }
}
