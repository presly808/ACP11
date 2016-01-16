package week4.model.commands;

import week4.model.BashCommand;
import week4.model.IBashCommand;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Created by 1 on 14.01.2016.
 */
public class Bash_touch extends BashCommand {
    @Override
    public void run() {

        if (getOptions().size() != 0 || getArguments().size() <= 0){
            throw new NoSuchElementException();
        }

        for (String argument : getArguments()) {
            String path = getCurrentPath() + FILE_PATH_SEPARATOR + argument;
            File fileToCreate = new File(path);

//            if (fileToCreate.exists()){
//                throw new NoSuchElementException();
//            }

            try {
                fileToCreate.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void help() {

    }
}
