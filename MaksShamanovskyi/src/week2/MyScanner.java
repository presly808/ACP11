package week2;

import java.io.*;

public class MyScanner implements IScanner{
    private char[] buff = new char[1024];
    private int index = 0;
    private Reader reader;
    private boolean closed = false;

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
            int temp = 0;
            for (;index < buff.length;) {
                temp = reader.read();
                if(temp == -1){
                    break;
                }
                buff[index++] = (char) temp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkBuffer(){
        if(index == buff.length){
            index = 0;
            writeToBuff();
            return true;
        }
        return false;
    }

    @Override
    public String nextLine() {
        String res = "";
        for (int i = 0; i < index; i++) {
            res += buff[i];
        }
        if(checkBuffer()){
            return res + nextLine();
        }
        return res;
    }

    @Override
    public String next() {
        return null;
    }

    @Override
    public int nextInt() {
        return 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasNextInt() {
        return false;
    }

    @Override
    public void useDelimiter(String delimiter) {

    }

    @Override
    public void close() {

    }
}
