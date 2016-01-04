package week4_Max.console.commands;

import java.io.File;

public class Rm extends Command {

    @Override
    public void run() {
        File file = new File(getFile().getAbsolutePath() + delimiter + getSimpleArg(0));
        if(file.exists() && file.isFile()){
            file.delete();
        }
    }

    @Override
    public String help() {
        return null;
    }
}
