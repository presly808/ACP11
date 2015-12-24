package utils;

import java.io.File;

/**
 * Created by slava23 on 12/23/2015.
 */
public class ClassPathResourceLoader {

    public static File load(String path){
        return new File(ClassPathResourceLoader.class.getResource(path).getFile());
    }

}
