package week_02;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by DNK on 17.12.2015.
 */
public class MyScanner {
    char myBuffer [] = new char[64];
    int curPos;

    public static void readStreamByte(InputStream inSt) throws IOException {
        while (true) {
            int oneByte = inSt.read();
            // если не конец файла
            if (oneByte != -1) {
                // выводим 1 символ
                System.out.print((char) oneByte);
            }
            // если дошли до конца файла
            else {
                System.out.print("\n" + "end stream");
                break;
            }
        }
        inSt.close();
    }


}
