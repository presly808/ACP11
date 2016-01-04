package week4_Max.console.commands;

import java.io.File;
import java.io.IOException;

public class Touch extends Command{

    @Override
    public void run() {
        try {
            new File(getFile().getAbsolutePath() + delimiter + getSimpleArg(0)).createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String help() {
        return null;
    }
}
