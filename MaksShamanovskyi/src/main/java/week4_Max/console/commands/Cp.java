package week4_Max.console.commands;

import week4_Max.console.ConsoleHelper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Cp extends Command {

    @Override
    public void run() {
        File file1 = new File(getFile().getAbsolutePath() + delimiter + getSimpleArg(0));
        if(file1.exists()) {
            File file2 = new File(getFile().getAbsolutePath() + delimiter + getSimpleArg(1));
            if(!file2.exists()){
                try {
                    file2.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                FileWriter fw = new FileWriter(file2);
                fw.write(ConsoleHelper.readFile(file1.getAbsolutePath()));
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String help() {
        return null;
    }
}
