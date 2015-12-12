package ua.artcode.checkpoint;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by DNK on 06.12.2015.
 */
public class RunCheckpoint {

    public static void main(String[] args){

        DataModule dataModule = new DataModule();
        dataModule.CreateDataStructure01();
        dataModule.startIniParam01();

        IOData timeNow = new IOData();
        System.out.println(timeNow.getDateTimeNowToStr());

        // вывод всех сотрудников на экран
        dataModule.printListStaffAll();


    }
}
