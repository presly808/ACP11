package week4_Max.console.commands;

import java.io.File;
import java.util.Date;

public class Ls extends Command {
    private File[] files;

    public void run() {
        init();
        for (File e : files) {
            if (getOptions().isEmpty()) {
                noOptions(e);
            } else if (getSimpleOption(0).equals("-a")) {
                aOption(e);
            } else if (getSimpleOption(0).equals("-l")) {
                lOption(e);
            } else if (getSimpleOption(0).equals("-al")) {
                alOption(e);
            }
        }
    }

    private void alOption(File e) {
        System.out.println(e.length() + " " + new Date(e.lastModified()) + " " + e.getName());
    }

    private void noOptions(File e) {
        if (!e.getName().startsWith(".")) {
            System.out.println(e.getName());
        }
    }

    private void init() {
        files = getFile().listFiles();
    }

    private void lOption(File e) {
        if (!e.getName().startsWith(".")) {
            System.out.println(e.length() + " " + new Date(e.lastModified()) + " " + e.getName());
        }
    }

    private void aOption(File e) {
            System.out.println(e.getName());
    }



    @Override
    public String help() {
        return null;
    }
}
