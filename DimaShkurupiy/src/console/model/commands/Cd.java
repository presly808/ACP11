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

    public void doExec(String[] args) {
        System.out.println("OPACHKI! command " + name + "was executed");
    }

 }
