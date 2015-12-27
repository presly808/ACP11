package ua.artcode.week4.socket;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by serhii on 27.12.15.
 */
public class ClientRun {


    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);

        Socket socket = new Socket("192.168.1.55",8888);

        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        Scanner input = new Scanner(socket.getInputStream());


        while(true){
            System.out.println(input.nextLine());
            pw.println(console.nextLine());
            pw.flush();
        }
    }
}
