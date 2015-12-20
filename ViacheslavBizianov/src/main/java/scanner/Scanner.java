package scanner;


import java.io.*;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Scanner {

    private Reader reader;

    char[] buff = new char[128];
    int pos;   //current position
    int nextInt = 0;

    public Scanner(Reader reader) {
        this.reader = reader;
    }

    public Scanner(String string){
        this(new CharArrayReader(string.toCharArray()));
    }

    public Reader getReader() {
        return reader;
    }

    public boolean hasNext() throws IOException {
        checkScannerOpened();
        try {
            return (this.getReader().read(buff,pos++,1) != -1);
        } catch (IOException e) {
            return false;
        }
    }

    public boolean hasNextInt(){
        checkScannerOpened();
        int start, end; //begin and end of int
        int res = 1;
        try {
            while (reader.read(buff,pos++,1) != -1){
                if (buff[pos-1] >= '0' && buff[pos-1] <= '9'){
                    nextInt = Character.getNumericValue(buff[pos-1]);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int nextInt(){
        checkScannerOpened();
        if (hasNextInt()){
            return nextInt;
        } else {
            throw new NoSuchElementException("No int was detected");
        }
    }

    private void checkScannerOpened() {
        if (buff == null){
            throw new NoSuchElementException("Scanner is closed");
        }
    }

    public void close(){
        buff = null;
    }

    public String next(){
        checkScannerOpened();
        String res = "";
        try {
            while (reader.read(buff,pos++,1) != -1 && buff[pos-1] != ' ' && buff[pos-1] != '\n'){
                res += buff[pos-1];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String nextLine(){
        checkScannerOpened();
        String res = "";
        try {
            while (reader.read(buff,pos++,1) != -1 && buff[pos-1] != '\n'){
                res += buff[pos-1];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

}
