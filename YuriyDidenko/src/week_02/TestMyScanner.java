package week_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static week_02.MyScanner.readStreamByte;

/**
 * Created by DNK on 17.12.2015.
 */
public class TestMyScanner {

    public static void main(String[] args) throws IOException {
        String filePath = "d:/java/test_text.txt";
        InputStream inFile = null;
        try {
            inFile = new FileInputStream(filePath);
            readStreamByte(inFile);
        }
        catch (IOException ioError) {
            throw  new IOException("Warning! Exception when open and read file "+filePath);
        }
        finally {
            // если файл открыть не удалось
            if (inFile != null) {
                try {
                    inFile.close();
                }
                catch (IOException ignore){
                    throw  new IOException("Warning! Exception when close file "+filePath);
                }
            }
        }
    }
}
