package week4.model.commands;

import week4.model.BashCommand;
import week4.model.IBashCommand;

import java.io.File;
import java.util.NoSuchElementException;

/**
 * Created by 1 on 14.01.2016.
 */
public class Bash_rm extends BashCommand {
    @Override
    public void run() {

        if (getOptions().size() != 0 || getArguments().size() <= 0){
            throw new NoSuchElementException();
        }
        for (String argument : getArguments()) {
            String filePath = getCurrentPath() + FILE_PATH_SEPARATOR + argument;
            File fileToDelete = new File(filePath);

            if (fileToDelete.exists()){
                fileToDelete.delete();
            }
        }

    }

    @Override
    public void help() {

    }
}
