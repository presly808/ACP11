package console.model.commands;

import console.model.Command;
import console.model.ICommandPlugin;

/**
 * Created by Шкурупий on 09.01.2016.
 */
public class Dir extends Command
                    implements ICommandPlugin {

    public Dir() {
        super.name = "dir";
    }

    public String doExec(int i) {
        return "command " + name + "was executed";
    }
}
