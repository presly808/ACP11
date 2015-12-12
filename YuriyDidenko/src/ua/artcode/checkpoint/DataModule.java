package ua.artcode.checkpoint;

import java.util.*;

/**
 * Created by DNK on 06.12.2015.
 */

public class DataModule {
    public HashMap<String, CardStaff> staffDB; // список всех сотрудников
    public List<CardStaff> listStaff; // список всех сотрудников
    public List<CheckPointLogRec> checkPointLogRecs; // журнал посещения сотрудниками предприятия
    //public final Date dateCreateCompany = new Date("2000.01.01");

    public void CreateDataStructure01(){
        staffDB = new HashMap<String, CardStaff>(); // array staff list
        listStaff = new ArrayList<CardStaff>(4);  // в учебных целях используем только 4 сотрудника, а значит можно точно определить размер списка
        checkPointLogRecs = new ArrayList<CheckPointLogRec>();
    }

    public void startIniParam01(){

        // create new staff
        CardStaff s1 = new CardStaff("0001", "Ivanov",    "Petr" );
        CardStaff s2 = new CardStaff("0002", "Rebrenko",  "Ivan" );
        CardStaff s3 = new CardStaff("0003", "Dub",       "Semen");
        CardStaff s4 = new CardStaff("0004", "Antonenko", "Elena");

        // save data about staff in HashMap
        staffDB.put(s1.getId(), s1);
        staffDB.put(s2.getId(), s2);
        staffDB.put(s3.getId(), s3);
        staffDB.put(s4.getId(), s4);

        // save data about staff in ArrayList
        //listStaff = Arrays.asList(s1, s2, s3, s4); потом нельзя использовать методы add, delete
        listStaff.add(s1);
        listStaff.add(s2);
        listStaff.add(s3);
        listStaff.add(s4);

    }

    // вывод всех сотрудников на экран
    public void printListStaffAll(){
        for (CardStaff item : listStaff) {
            System.out.println(item.toString());
        }

    }



}
