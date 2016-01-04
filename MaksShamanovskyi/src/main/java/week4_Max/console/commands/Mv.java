package week4_Max.console.commands;

import java.io.File;

public class Mv extends Command {
    @Override
    public void run() {
        File file1 = new File(getFile().getAbsolutePath() + delimiter + getSimpleArg(0));
        if(file1.exists()){
            File file2 = new File(getFile().getAbsolutePath() + delimiter + getSimpleArg(1));
            if(file2.isDirectory()){
                file1.renameTo(new File(file2, file1.getName()));
            }
            file1.renameTo(file2);
        }
    }

    @Override
    public String help() {
        return null;
    }
}
