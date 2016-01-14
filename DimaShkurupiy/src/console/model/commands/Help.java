package console.model.commands;

import console.model.Command;
import console.model.CurrentState;
import console.model.ICommandPlugin;
import console.utils.ReflectionUtils;

/**
 * Created by Dima on 13.01.2016.
 */
public class Help extends Command
        implements ICommandPlugin {

    public Help(CurrentState currentState) {
        super.name = "help";
        super.currentState = currentState;
        super.help = "help (Help - commands list)";
    }

    public String doExec(String[] args)  {
        StringBuilder cb = new StringBuilder();
        for (Command c : currentState.getCommands()) {
            try {
                cb.append(ReflectionUtils.callMethodWOParams(c, "getHelp"));
                cb.append("\n");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return cb.toString();

    }

}
