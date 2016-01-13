package week_04.day2;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Dima on 27.12.2015.
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);

        Socket socket = new Socket("192.168.1.55", 8888);

        PrintWriter pw = new PrintWriter(socket.getOutputStream());

    }
}
