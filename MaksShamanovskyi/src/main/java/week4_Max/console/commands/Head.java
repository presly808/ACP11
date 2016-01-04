package week4_Max.console.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Head extends Command {

    @Override
    public void run() {
        File file = new File(getFile().getAbsoluteFile() + delimiter + getSimpleArg(0));
        if(file.exists() && !getOptions().isEmpty()) {
            int num = Integer.parseInt(getSimpleOption(0).substring(1, getSimpleOption(0).length()));
            int count = 0;
            String res = "";
            char temp;
            try {
                FileReader fileReader = new FileReader(file);
                while (fileReader.ready()) {
                    if (num == count) {
                        break;
                    }
                    if ((temp = (char) fileReader.read()) == '\n') {
                        count++;
                    }
                    res += temp;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(res);
        }
    }

    @Override
    public String help() {
        return null;
    }
}
