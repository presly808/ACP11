package console.model.commands;

import console.model.Command;
import console.model.ICommandPlugin;

/**
 * Created by Шкурупий on 08.01.2016.
 */
public class Cd extends Command
                    implements ICommandPlugin {

    public Cd() {
        super.name = "cd";
    }

    public String doExec(int i) {
        System.out.println("OPACHKI!");
        return "command " + name + "was executed";
    }

 }
