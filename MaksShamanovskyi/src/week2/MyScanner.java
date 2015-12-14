package week2;

import java.io.*;
import java.util.NoSuchElementException;

public class MyScanner implements IScanner{
    private char[] buff = new char[8];
    private int end = 0;
    private int start = 0;
    private Reader reader;
    private boolean closed = false;
    private char[] delimiter = {' '};

    public MyScanner(String text){
        reader = new StringReader(text);
        writeToBuff();
    }

    public MyScanner(Reader reader){
        this.reader = reader;
        writeToBuff();
    }

    public MyScanner(InputStream inputStream){
        reader = new InputStreamReader(inputStream);
        writeToBuff();
    }

    private void writeToBuff(){
        try {
            reader.mark(buff.length);
            end = reader.read(buff);
            if(reader.read() == -1){
                close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkBuffer(){
        if(end == buff.length){
            start = 0;
            end = 0;
            writeToBuff();
        }
    }

    @Override
    public String nextLine() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        String res = "";
        for (; start < end;) {
            res += buff[start++];
        }
        if(start == end){
            if(closed){
                return res;
            }
            checkBuffer();
            return res + nextLine();
        }
        return res;
    }

    @Override
    public String next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        String res = "";
        for(;buff[start] != delimiter[0] && start < end; start++) {
            res += buff[start];
        }
        start += delimiter.length;
        if(start == end){
            checkBuffer();
            return res + next();
        }
        return res;
    }

    @Override
    public int nextInt() {
        return 0;
    }

    @Override
    public boolean hasNext() {
        if(buff[start] != '\u0000'){
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNextInt() {
        return false;
    }

    @Override
    public void useDelimiter(String delimiter) {
        this.delimiter = delimiter.toCharArray();
    }

    @Override
    public void close() {
        try {
            if(!closed) {
                closed = true;
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
