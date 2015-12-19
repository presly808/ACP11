package ua.artcode.io;

import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * Created by serhii on 12.12.15.
 */
public class TestIoMethods {


    public static final String PATH = "/home/serhii/dev/IdeaProjects/ACP11/home/main.week1.txt";

    public static void main(String[] args) throws FileNotFoundException {
        int[] mas = IOMethodContainer.readFileContent(
                PATH);
        System.out.println(Arrays.toString(mas));
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        System.out.println(IOMethodContainer.readFileCodeContentAsString(PATH));
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(IOMethodContainer.readFileContentBuff(PATH));
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        //System.out.println(IOMethodContainer.readFileContentAsString(PATH));
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }
}
