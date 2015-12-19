package ua.artcode.week2;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.NoSuchElementException;

public class MyScanner implements IScanner{
    private char[] buff = new char[1024];
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

    private void writeToBuff(){
        try {
            end = reader.read(buff);
            if(end < buff.length){
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
        for(;start < end && buff[start] != delimiter[0]; start++) {
            res += buff[start];
        }
        start += delimiter.length;
        if(start >= end){
            checkBuffer();
            return res + next();
        }
        return res;
    }

    @Override
    public int nextInt() {
        if(!hasNextInt()){
            throw new NoSuchElementException();
        }
        String res = "";
        for(;start < end && buff[start] != delimiter[0]; start++) {
            res += buff[start];
        }
        start += delimiter.length;
        if(start >= end){
            checkBuffer();
            return Integer.parseInt("" + res + nextInt());
        }
        return Integer.parseInt(res);
    }

    @Override
    public boolean hasNext() {
        if(start >= end && end < buff.length){
            return false;
        }
        return buff[start] != delimiter[0] || buff[start] != '\u0000';
    }

    @Override
    public boolean hasNextInt() {
        int index = start;
        if(hasNext()) {
            for (; buff[index] != delimiter[0] && buff[index] != '\u0000'; ) {
                if (buff[index] < '\u0030' || buff[index] > '\u0039') {
                    return false;
                }
                index++;
            }
        }
        return true;
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
