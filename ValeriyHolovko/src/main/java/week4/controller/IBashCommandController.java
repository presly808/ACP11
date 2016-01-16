package week4.controller;

import week4.model.BashCommand;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by 1 on 14.01.2016.
 */
public interface IBashCommandController {

    void run(String str);
    BashCommand getCommand(String command);
    ArrayList<String> getOptions(String[] str);
    ArrayList<String> getArgument(String[] str);

}
