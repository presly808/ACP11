package ua.artcode.week2;


import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.util.NoSuchElementException;

public class Scanner implements IScanner{

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

    @Override
    public boolean hasNext() {
        checkScannerOpened();
        try {
            return (this.getReader().read(buff,pos++,1) != -1);
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean hasNextInt(){
        checkScannerOpened();
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

    @Override
    public void useDelimiter(String delimiter) {

    }

    @Override
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

    @Override
    public void close(){
        buff = null;
    }

    @Override
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

    @Override
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
