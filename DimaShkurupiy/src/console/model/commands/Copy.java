package console.model.commands;

import console.model.Command;
import console.model.CurrentState;
import console.model.ICommandPlugin;

/**
 * Created by Шкурупий on 08.01.2016.
 */
public class Copy extends Command
                    implements ICommandPlugin {

    public Copy(CurrentState currentState) {
        super.name = "copy";
        super.currentState = currentState;
        super.help = "copy (Copy file or directory)";
    }

    public String doExec(String[] args) {
        return "command " + name + " was executed";
    }
}
