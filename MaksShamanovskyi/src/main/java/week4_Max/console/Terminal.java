package week4_Max.console;

import week4_Max.console.commands.*;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;


public class Terminal {
    private HashMap<String, Command> commands = new HashMap<>();
    private String home = System.getProperty("user.home");
    private Scanner sc = new Scanner(System.in);
    private File file = new File(home);
    private Command command;
    private String line;
    private String commandName;

    public Terminal() {
        init();
        run();
    }

    private void init() {
        commands.put("ls", new Ls());
        commands.put("cd", new Cd());
        commands.put("pwd", new Pwd());
        commands.put("mkdir", new Mkdir());
        commands.put("touch", new Touch());
        commands.put("cat", new Cat());
        commands.put("rm", new Rm());
        commands.put("cp", new Cp());
        commands.put("mv", new Mv());
        commands.put("head", new Head());
        commands.put("help", new Help());
    }

    private void run() {
        while (true) {
            System.out.println(file.getAbsolutePath() + "> ");
            setCommand();
            if (command instanceof Help) {
               new Help(commands.get(command.getSimpleArg(0)));
            }
            command.run();
            if (command instanceof Cd) {
                file = command.getFile();
            }
        }
    }

    private void setCommand() {
        if (sc.hasNext()) {
            line = sc.nextLine();
            commandName = ConsoleHelper.getCommandName(line);
            if (commands.containsKey(commandName)) {
                command = commands.get(commandName);
                command.setFile(file);
                command.setOptions(ConsoleHelper.getOptions(line));
                command.setArgs(ConsoleHelper.getArguments(line, commandName));
            }
        }

    }

}
