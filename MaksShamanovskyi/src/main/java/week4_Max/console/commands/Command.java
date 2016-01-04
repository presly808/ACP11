package week4_Max.console.commands;

import java.io.File;
import java.util.ArrayList;

public abstract class Command implements ICommand {
    static String delimiter = System.getProperty("file.separator");
    private ArrayList<String> options;
    private ArrayList<String> args;
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public String getSimpleOption(int index) {
        return options.get(index);
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public String getSimpleArg(int index) {
        return args.get(index);
    }

    public void setArgs(ArrayList<String> args) {
        this.args = args;
    }
}
