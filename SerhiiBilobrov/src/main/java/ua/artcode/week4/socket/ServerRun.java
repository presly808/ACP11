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



    public static void main(String[] args) throws IOException {
        //192.168.1.55 8888
        // telnet 192.168.1.55 8888
        new Thread(new ServerThread()).start();


    }

}

class ServerThread implements Runnable {

    private static int count = 1;
    public final static List<String> HISTORY = new LinkedList<>();
    private static long start = System.currentTimeMillis();

    @Override
    public void run() {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("Server started");
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error("Can not run server");
        }

        try {
            while(true){
                Socket client = serverSocket.accept();
                Thread th = new Thread(new ClientThread(client, count++)); //
                th.start();// start new thread , non blocking
                System.out.println("started new client " + client.getInetAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientThread implements Runnable {

    private Socket socket;
    private int count;
    private int readCount;

    public ClientThread(Socket socket, int count) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (PrintWriter output = new PrintWriter(socket.getOutputStream());){

            while(true){
                Scanner input = new Scanner(socket.getInputStream());

                StringBuilder sb = new StringBuilder();
                if(readCount < ServerThread.HISTORY.size()){
                    for (;readCount < ServerThread.HISTORY.size(); readCount++) {
                        sb.append(ServerThread.HISTORY.get(readCount)).append("");
                    }
                }
                output.println(sb.toString());
                output.flush();


                output.println("Hi from server, your number is "
                        + count + ", time" + new Date().toString());
                output.flush();

                String contentFromClient = input.hasNextLine() ? input.nextLine() : "no response from client";
                String message = socket.getInetAddress() + " " + contentFromClient;

                ServerThread.HISTORY.add(message);
                readCount++;

                System.out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
