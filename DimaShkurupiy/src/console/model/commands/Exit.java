package console.model.commands;

import console.model.Command;
import console.model.CurrentState;
import console.model.ICommandPlugin;

/**
 * Created by Dima on 13.01.2016.
 */
public class Exit extends Command
        implements ICommandPlugin {

    public Exit(CurrentState currentState) {
        super.name = "exit";
        super.currentState = currentState;
        super.help = "exit (Exit this program)";
    }

    public String doExec(String[] args) {
        System.exit(999);
        return "see you!"; // TODO ну и как отсюда выкинуть строку?
    }

}
