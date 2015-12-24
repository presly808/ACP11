package url;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class DownloadFile {
    public static void downloadFile(String sourcePath, String targetPath) throws IOException {

        URL url = null;

        try {
            url = new URL(sourcePath);
            InputStream is = new BufferedInputStream(url.openStream());
            OutputStream ous = new FileOutputStream(new File(targetPath));

            byte[] buffer = new byte[1024];
            int index;
            int count = 0;
            while ((index = is.read()) != -1){
                if (count >= buffer.length){
                    ous.write(buffer);
                    ous.flush();
                    count = 0;
                }
                buffer[count++] = (byte) index;
            }
            ous.flush();
            ous.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
