package MyScanner;


import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class MyScanner {

    private Reader reader;
    private char[] buffer = new char[1024];
    private String string;
    private int pos;


    public MyScanner(String text){
        reader = new StringReader(text);
    }

    public MyScanner(Reader reader){
        this.reader = reader;
    }


    public Reader getReader() {
        return reader;
    }


//    public char [] writeToBuffer(String string) {
//        for (int i = 0; i < string.length()  ; i++) {
//            char [] buffer = string.toCharArray();
//        }
//        return buffer;
//    }

    public boolean hasNext() throws IOException {
        checkScannerOpened();
        try {

            return (this.getReader().read(buffer,pos++,1) != -1);
        } catch (IOException e) {
            return false;
        }
    }

    private boolean checkScannerOpened() {
        return (buffer != null);
    }

    private void close(){
        buffer = null;
    }


    public String next()throws IOException {
        checkScannerOpened();
        try {
            this.getReader().read(buffer);
            while (this.getReader().read(buffer,pos++,1) != -1){
                 if ((buffer[pos] != -1) && (buffer[pos] != ' ')) return  string = string + buffer[pos];
            }
            return string;
        } catch (IOException e) {
            return null;
        }

//        String res = "";
//        try {
//            while (reader.read(buffer,pos++,1) != -1 && buffer[pos-1] != ' ' && buffer[pos-1] != '\n'){
//                res += buffer[pos-1];
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return res;
    }




    public int nextInt(){

        return -1;
    }


    public String nextLine(){

        return "";
    }




    public  boolean hasNextInt(){

        return false;
    }

//    public static useDelemiter(String){
//
//    }
//    public static close(){
//
//    }




}
