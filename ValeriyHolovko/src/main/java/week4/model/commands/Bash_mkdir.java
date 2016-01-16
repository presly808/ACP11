package week4.model.commands;

import week4.model.BashCommand;
import week4.model.IBashCommand;

import java.io.File;
import java.util.NoSuchElementException;

/**
 * Created by 1 on 14.01.2016.
 */
public class Bash_mkdir extends BashCommand {
    @Override
    public void run() {

        if (getArguments().size() != 1 || getOptions().size() != 0){
            throw new NoSuchElementException();
        }

        String path = getCurrentPath().getAbsolutePath()  + FILE_PATH_SEPARATOR + getArguments().get(0);
        new File(path).mkdir();
    }

    @Override
    public void help() {

    }
}
