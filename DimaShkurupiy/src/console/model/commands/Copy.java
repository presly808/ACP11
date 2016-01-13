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

    public void doExec(String[] args) {
        System.out.println("command " + name + "was executed");
    }
}
