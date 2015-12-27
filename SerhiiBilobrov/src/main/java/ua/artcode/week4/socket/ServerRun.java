package ua.artcode.week4.socket;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Created by serhii on 27.12.15.
 */
public class ServerRun {

    private static int count = 1;
    private static List<String> history = new LinkedList<>();
    private static long start = System.currentTimeMillis();

    public static void main(String[] args) throws IOException {
        //192.168.1.55 8888
        // telnet 192.168.1.55 8888
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("START SERVER");
        while (System.currentTimeMillis() - start < 20000) {

            Socket client = serverSocket.accept(); // wait for clients, blocking method
            PrintWriter output = new PrintWriter(client.getOutputStream());
            Scanner input = new Scanner(client.getInputStream());

            output.println("Hi from server, your number is "
                    + count + ", time" + new Date().toString());
            output.flush();

            String message = client.getInetAddress().toString() + " " + input.nextLine();

            history.add(message);
            System.out.println(message);
        }


        String res = String.join("\n", history);
        runCommand("cd ~ && echo \"" + res + "\" > result.txt");



    }

    public static void runCommand(String command){
        try {
            Process process = Runtime.getRuntime().exec(command);
            int res = process.waitFor();

            if(res == 0){
                System.out.println("Success");
                System.out.println(IOUtils.toString(process.getInputStream()));
            } else {
                System.out.println("Failed");
                System.err.println(IOUtils.toString(process.getInputStream()));
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
