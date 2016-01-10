package console.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by DNK on 08.01.2016.
 */
public class ConsoleRun {

    public static void runExecLite() throws IOException, InterruptedException {

        Runtime r = Runtime.getRuntime();
        Process p = null;
        //String cmd[] = {"notepad","d:/temp/color_table.txt"};
        String cmd[] = {"cmd","help /?"};

        String command = "c:/Program Files (x86)/GIF animator/GIF_ANI.exe";
        //String command = "mkdir d:\\temp\\222";
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", command);

        try{
            Process p1 = pb.start();
            //p = r.exec(cmd);
        }
        catch(Exception e){
        }

        ConsoleRun cRun = new ConsoleRun();
        //cRun.runExec();
    }

    public static void runExec(String commName, String ... args) throws IOException, InterruptedException {

        /* ��������� � ������������ ProcessBuilder,
        /* ��� ����� ��������� ��������� ��������� � ����������� */
        //ProcessBuilder procBuilder = new ProcessBuilder("cmd.exe", "/c", "notepad d:/temp/color_table.txt");
        //ProcessBuilder procBuilder = new ProcessBuilder("d:\\temp\\createdir.bat");
        //ProcessBuilder procBuilder = new ProcessBuilder("cmd.exe", "/c", "mkdir d:\\Temp\\333");
        //ProcessBuilder procBuilder = new ProcessBuilder("cmd.exe", "/c", "rmdir d:\\temp\\333");
        String params = "";
        for (String s : args) {
            params += " " + s;
        }
        ProcessBuilder procBuilder = new ProcessBuilder("cmd.exe", "/c", commName, params);


        // �������������� ����������� ����� ������ �� ����������� �����
        procBuilder.redirectErrorStream(true);

        // ������ ���������
        Process process = procBuilder.start();

        // ������ ����������� ����� ������ � ������� �� �����
        InputStream stdout = process.getInputStream();
        InputStreamReader isrStdout = new InputStreamReader(stdout);
        BufferedReader brStdout = new BufferedReader(isrStdout);

        String line = null;
        while ((line = brStdout.readLine()) != null) {
            System.out.println(line);
        }

        // ���� ���� ���������� ��������� ��������� � ��������� ���, � ������� ��� ����������� �
        // � ���������� exitVal
        int exitVal = process.waitFor();
    }

}
