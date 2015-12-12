package ua.artcode.checkpoint;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by DNK on 11.12.2015.
 */

public class IOData {

    public void saveData(Object obj){
        //String dateTimeNow = new String(System.currentTimeMillis());
        String fileName = "Checkpoint_"+getDateTimeNowToStr()+".txt";
        //FileOutputStream fileOutputStream = new FileOutputStream(fileName);

    }

    public String getDateTimeNowToStr() {

        // Для получения текущего системного времени
        long curTime = System.currentTimeMillis();

        // значение типа Date с этим временем
        Date curDate = new Date(curTime);

        // строка в формате, удобном для вывода
        String curStringDateTime = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").format(curTime);

        return curStringDateTime;
    }

    public Date getDateTimeNow() {

        // Для получения текущего системного времени
        long curTime = System.currentTimeMillis();

        // значение типа Date с этим временем
        Date curDateTime = new Date(curTime);

        // Date из строки, в которой дата с заданным шаблоном
        //System.out.println( new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").format(timeNow.getDateTimeNow()) );

        return curDateTime ;
    }
}
