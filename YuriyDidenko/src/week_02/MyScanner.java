package week_02;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by DNK on 17.12.2015.
 */
public class MyScanner {

    public static void readStreamByte(InputStream inSt) throws IOException {
        while (true) {
            int oneByte = inSt.read();
            // ���� �� ����� �����
            if (oneByte != -1) {
                // ������� 1 ������
                System.out.print((char) oneByte);
            }
            // ���� ����� �� ����� �����
            else {
                System.out.print("\n" + "end stream");
                break;
            }
        }
        inSt.close();
    }


}
