package week4_Max.console;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleHelper {

    public static String getCommandName(String line){
        if(line.indexOf(" ") < 0){
            return line;
        }
        int indexSpace = line.indexOf(" ");
        return line.substring(0, indexSpace);
    }


    public static ArrayList<String> getOptions(String line){
        ArrayList<String> filters = new ArrayList<>();
        String pattern = "\\s\\-\\w+";
        Pattern reg = Pattern.compile(pattern);
        Matcher m = reg.matcher(line);
        while(m.find()) {
            filters.add(m.group(m.groupCount()).trim());
        }
        return filters;
    }

    public static ArrayList<String> getArguments(String line, String command){
        ArrayList<String> filters =  getOptions(line);
        ArrayList<String> params = new ArrayList<>();
        String[] words = line.split(" ");
        for(int i = 0; i < words.length; i++){
            if(!command.equals(words[i]) &&  !checkStrInList(words[i], filters)){
                params.add(words[i]);
            }
        }
        return params;

    }
    public static boolean checkStrInList(String str, List<String> strings){
        for(String s: strings){
            if(s.contains(str)){
                return true;
            }
        }
        return false;

    }

    public static boolean findFile(String path){
        File file = new File(path);
        return file.exists();
    }

    public static String readFile(String path){
        String res = "";
            try {
                FileReader fileReader = new FileReader(path);
                while(fileReader.ready()){
                    res += (char) fileReader.read();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return res;
    }
}
