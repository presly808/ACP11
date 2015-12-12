package ua.artcode.checkpoint;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by DNK on 06.12.2015.
 */
public class RunCheckpoint {

    public static void main(String[] args){

        // блок инициализации стартовых параметров
        DataModule dataModule = new DataModule();
        dataModule.CreateDataStructure01();
        dataModule.startIniParam01();

        // вывод всех сотрудников на экран
        System.out.println();
        System.out.println("-=< СПИСОК ВСЕХ СОТРУДНИКОВ >=-");
        dataModule.printListStaffAll();

        dataModule.showCheckPointLogAll(dataModule, 1);
        dataModule.showCheckPointLogAll(dataModule, 2);

    }
}
