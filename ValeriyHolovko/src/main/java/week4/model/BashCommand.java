package week4.model;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by 1 on 14.01.2016.
 */
public abstract class BashCommand implements IBashCommand {

    protected String FILE_PATH_SEPARATOR = System.getProperty("file.separator");
    private File currentPath;
    private ArrayList<String> options = new ArrayList<>();
    private ArrayList<String> arguments = new ArrayList<>();

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public ArrayList<String> getArguments() {
        return arguments;
    }

    public void setArguments(ArrayList<String> arguments) {
        this.arguments = arguments;
    }

    public File getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(File currentPath) {
        this.currentPath = currentPath;
    }
}
