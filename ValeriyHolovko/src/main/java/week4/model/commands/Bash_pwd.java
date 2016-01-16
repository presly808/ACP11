package week4.model.commands;

import week4.model.BashCommand;
import week4.model.IBashCommand;

import java.util.NoSuchElementException;

/**
 * Created by 1 on 14.01.2016.
 */
public class Bash_pwd extends BashCommand {
    @Override
    public void run() {
        if (getOptions().size() != 0 || getArguments().size() != 0){
            throw new NoSuchElementException();
        }
        System.out.println(getCurrentPath().getAbsolutePath());
    }

    @Override
    public void help() {

    }
}
