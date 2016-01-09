package console.model.commands;

import console.model.Command;
import console.model.ICommandPlugin;

/**
 * Created by Шкурупий on 08.01.2016.
 */
public class Copy extends Command
                    implements ICommandPlugin {

        public Copy() {
        super.name = "copy";
    }

    public String doExec(int i) {
        return "command " + name + "was executed";
    }
}
