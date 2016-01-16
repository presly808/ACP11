package console.model;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import console.Console;

import static console.utils.CommUtils.getClasses;

/**
 * Created by Шкурупий on 08.01.2016.
 */
public class CurrentState {
    // todo make the conf init file for PATH etc
    public String currentPath = "D:\\dima\\java\\acp11";
    public ArrayList<String> history = new ArrayList<>();
    public String path;
    private final SynchronousQueue<String> userCommand = new SynchronousQueue<String>();

    private List<Class> commandsClasses;
    private List<Command> commands = new ArrayList<>();

    public CurrentState() throws Exception {
        this.commandsClasses = getClasses(Console.class.getClassLoader(),"console/model/commands");
        for(Class c:this.commandsClasses){
            Constructor constr = c.getConstructor(this.getClass());
            commands.add((Command) constr.newInstance(this) );
        }
    }

    public String getCurrentPath() {
        return this.currentPath;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setUserCommand(String userCommand) {
        try {
            this.userCommand.put(userCommand);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getUserCommand() {
        try {
            return this.userCommand.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }
}
