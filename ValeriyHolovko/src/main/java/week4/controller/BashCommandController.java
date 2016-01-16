package week4.controller;

import week4.model.BashCommand;
import week4.model.commands.*;
import week4.view.Terminal;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/**
 * Created by 1 on 14.01.2016.
 */
public class BashCommandController implements IBashCommandController {

    String HOME_DIRECTORY_PATH = System.getProperty("user.home");
    File currentPath = new File(HOME_DIRECTORY_PATH);
    Map<String, BashCommand> commands = new TreeMap<>();
    String INPUT_STR_PARSING_DELIMITER = " ";

    public BashCommandController() {
        init();
    }

    private void init(){
        commands.put("cd",new Bash_cd());
        commands.put("cp",new Bash_cp());
        commands.put("help",new Bash_help());
        commands.put("ls",new Bash_ls());
        commands.put("man",new Bash_man());
        commands.put("mkdir",new Bash_mkdir());
        commands.put("mv",new Bash_mv());
        commands.put("pwd",new Bash_pwd());
        commands.put("rm", new Bash_rm());
        commands.put("touch", new Bash_touch());
    }


    @Override
    public void run(String str) throws NullPointerException,NoSuchElementException{
        String[] parsedInput = str.split(INPUT_STR_PARSING_DELIMITER);
        String commandName = parsedInput[0];

        BashCommand command = getCommand(commandName);

        command.setOptions(getOptions(parsedInput));
        command.setArguments(getArgument(parsedInput));
        command.setCurrentPath(currentPath);

        command.run();
    }

    @Override
    public BashCommand getCommand(String commandName){
        if (commands.containsKey(commandName)) {
            return commands.get(commandName);
        }
        throw new NullPointerException();
    }

    @Override
    public ArrayList<String> getOptions(String[] input) {

        ArrayList<String> options = new ArrayList<>();
        
        for (String word : input) {

            if (word.startsWith("-")){
                options.add(word.substring(1));
            } else if (word.startsWith("--")){
                options.add(word.substring(2));
            }

        }

        return options;
    }

    @Override
    public ArrayList<String> getArgument(String[] input) {

        ArrayList<String> arguments = new ArrayList<>();

        for (String word : input) {

            if (!word.startsWith("-") && !word.startsWith("--") && input[0] != word){
                arguments.add(word);
            }

        }

        return arguments;

    }

    public File getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(File currentPath) {
        this.currentPath = currentPath;
    }


}
