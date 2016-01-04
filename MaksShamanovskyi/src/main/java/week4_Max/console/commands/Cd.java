package week4_Max.console.commands;

import week4_Max.console.ConsoleHelper;

import java.io.File;

public class Cd extends Command{

    @Override
    public void run() {
        String path = getFile().getAbsolutePath();
        if(getArgs().isEmpty() || getSimpleArg(0).equals(".")){
        }else if(getSimpleArg(0).equals("..")){
            int index = path.lastIndexOf(delimiter);
            setFile(new File(path.substring(0, index)));
        }else {
            String NewPath = path + delimiter + getSimpleArg(0);
            if (ConsoleHelper.findFile(NewPath)) {
                setFile(new File(NewPath));
            }
        }
    }

    @Override
    public String help() {
        return "CHDIR [/D] [drive:][path]\n" +
                "CHDIR [..]\n" +
                "CD [/D] [drive:][path]\n" +
                "CD [..]\n" +
                ".. Specifies that you want to change to the parent directory.\n" +
                "Type CD drive: to display the current directory in the specified drive.\n" +
                "Type CD without parameters to display the current drive and directory.\n" +
                "Use the /D switch to change current drive in addition to changing current directory for a drive.\n" +
                "If Command Extensions are enabled CHDIR changes as follows:\n" +
                "The current directory string is converted to use the same case as the on disk names. So CD C:\\TEMP would actually set the current directory to C:\\Temp if that is the case on disk.\n" +
                "CHDIR command does not treat spaces as delimiters, to CD into a subdirectory name that contains a space without surrounding the name with quotes. For example:\n" +
                "chdir \\winnt\\profiles\\username\\programs\\start menu\n" +
                "\n" +
                "is the same as:\n" +
                "cd \"\\winnt\\profiles\\username\\programs\\start menu\"\n" +
                "\n" +
                "which is what you would have to type if extensions were disabled.";
    }
}
