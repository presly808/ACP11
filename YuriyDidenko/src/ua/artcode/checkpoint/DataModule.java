package ua.artcode.checkpoint;

import java.util.*;

/**
 * Created by DNK on 06.12.2015.
 */

public class DataModule {
    // список всех сотрудников (альтернативный вариант)
    public HashMap<String, CardStaff> staffDB;

    // БАЗОВЫЕ СТРУКТУРЫ ДАННЫХ ПРОГРАММЫ
    // список всех сотрудников
    public List<CardStaff> listStaff;
    // журнал посещения сотрудниками предприятия
    public List<CheckPointLogRec> checkPointLogRecs;


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
        //listStaff = Arrays.asList(s1, s2, s3, s4); но потом нельзя использовать методы add, delete
        listStaff.add(s1);
        listStaff.add(s2);
        listStaff.add(s3);
        listStaff.add(s4);

        Date d1 = new Date();
        Date d2 = new Date();

        d1.setTime(d1.getTime()-20000000);
        d2.setTime(d2.getTime()-777770);
        checkPointLogRecs.add(new CheckPointLogRec("0002", d1, d2) );

        d1 = new Date();
        d2 = new Date();
        d1.setTime(d1.getTime()-15000000);
        checkPointLogRecs.add(new CheckPointLogRec("0004", d1, d2) );

        d1 = new Date();
        d2 = new Date();
        d1.setTime(d1.getTime()-10000000);
        checkPointLogRecs.add(new CheckPointLogRec("0003", d1, null) );
    }

    // вывод всех сотрудников на экран
    public void printListStaffAll(){
        for (CardStaff item : listStaff) {
            System.out.println(item.toString());
        }
    }

    // поиск индекса в списке сотрудников зная его персональный код
    public int getIndexStaff(String id){
        for (int i = 0; i < listStaff.size(); i++){
            if (listStaff.get(i).getId() == id) {
                return i;
            }
        }
        return -1; // id not found
    }

    // вывод на экран журнала посещений
    // typeSort { 1 - сортировка по возрастанию дат, 2 - обратная сотрировка}
    public void showCheckPointLogAll(DataModule dataModule, int typeSort){
        System.out.println();
        System.out.println("-=< ЖУРНАЛ ПОСЕЩЕНИЯ СОТРУДНИКОВ >=-");
        System.out.println("Время начала работы | Время окончания     |Сотрудник");
        // 1 - сортировка по возрастанию дат
        if (typeSort == 1) {
            for (int i = 0; i <  dataModule.checkPointLogRecs.size(); i++) {
                System.out.println(dataModule.getCheckPointLogRecsToStr(dataModule, i));
            }
        }
        // 2 - обратная сотрировка
        if (typeSort == 2) {
            for (int i = dataModule.checkPointLogRecs.size() - 1; i >= 0; i--) {
                System.out.println(dataModule.getCheckPointLogRecsToStr(dataModule, i));
            }
        }
    }

    private String getCheckPointLogRecsToStr(DataModule dataModule, int curIndex){
        StringBuilder sb = new StringBuilder();
        // поиск сотрудника по персональному коду в списке сотрудников
        int indexStaff = dataModule.getIndexStaff(dataModule.checkPointLogRecs.get(curIndex).getIdCardStaff());
        //если результат <> -1, значит сотрудник найден :)
        if (indexStaff != -1) {
            // вывод даты и времени в заданном формате
            sb.append(new IOData().getDateTimeToStr(dataModule.checkPointLogRecs.get(curIndex).getDateTimeIn(), "yyyy.MM.dd HH:mm:ss"));
            sb.append(" | ");
            sb.append(new IOData().getDateTimeToStr(dataModule.checkPointLogRecs.get(curIndex).getDateTimeOut(), "yyyy.MM.dd HH:mm:ss"));
            sb.append(" ");
            sb.append(dataModule.listStaff.get(indexStaff).toString());
        }
        return sb.toString();
    }

}
