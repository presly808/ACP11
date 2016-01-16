package week4.model.commands;

import week4.model.BashCommand;
import week4.model.IBashCommand;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.NoSuchElementException;

/**
 * Created by 1 on 14.01.2016.
 */
public class Bash_mv extends BashCommand {
    @Override
    public void run() {
        if (getOptions().size() != 0 || getArguments().size() != 2){
            throw new NoSuchElementException();
        }

        File fileToMove = new File(getCurrentPath() + FILE_PATH_SEPARATOR + getArguments().get(0));

        if (!fileToMove.exists() || !fileToMove.isFile()){
            throw new NoSuchElementException();
        }

        File directoryToMoveInto = new File(getArguments().get(1));


        if (!directoryToMoveInto.exists()){
            directoryToMoveInto.mkdir();
        }

        if (!directoryToMoveInto.isDirectory()){
            throw new NoSuchElementException();
        }

        fileToMove.renameTo(new File(directoryToMoveInto,fileToMove.getName()));


    }

    @Override
    public void help() {

    }
}
