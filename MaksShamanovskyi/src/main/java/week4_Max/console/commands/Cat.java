package week4_Max.console.commands;

import week4_Max.console.ConsoleHelper;

public class Cat extends Command {

    @Override
    public void run() {
        String file = getFile().getAbsolutePath() + delimiter + getSimpleArg(0);
        if (ConsoleHelper.findFile(file)) {
            String res = ConsoleHelper.readFile(file);
            System.out.println(res);
        }
    }

    @Override
    public String help() {
        return null;
    }
}
