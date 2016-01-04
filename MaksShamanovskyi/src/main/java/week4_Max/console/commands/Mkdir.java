package week4_Max.console.commands;

import java.io.File;

public class Mkdir extends Command {
    @Override
    public void run() {
        new File(getFile().getAbsolutePath() + delimiter + getSimpleArg(0)).mkdir();
    }

    @Override
    public String help() {
        return null;
    }
}
