package ua.artcode.checkpoint;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DNK on 06.12.2015.
 */
public class Checkpoint {

    // поиск записи сотрудника в журнале по коду и текущей дате
    public int searchIDStaff(List<CheckPointLogRec> checkpointLog, String idStaff){
        for (int i = checkpointLog.size()-1; i >= 0; i--) {
            if (checkpointLog.get(i).getIdCardStaff() == idStaff) {
                if (checkpointLog.get(i).getDateTimeIn().equals(new Date(System.currentTimeMillis()))) {
                    if (checkpointLog.get(i).getDateTimeOut().toString()=="") {
                        return i;
                    }
                }
            }
        }
        return -1; // запись не найдена
    }

    // idStaff - считываем на входе код сотрудника при контакте его магнитной карты с картридером на проходной
    public void staffInWork(List<CheckPointLogRec> checkpointLog, String idStaff){
        // вначале ищем, есть ли уже на текущую дату запись с кодом сотрудника cardStaff в журнале посещений
        // если нашли, то проверяем заполнено ли поле "dateTimeOut", т.е. время выхода с работы
        // если не заполнено - ошибка! повторный вход без выхода...
        // если заполнено или не нашли, значит все ок, создаем новую запись в журнале посещений с открытым полем "dateTimeOut-выход"
    }

    // idStaff - считываем на выходе код сотрудника при контакте его магнитной карты с картридером на проходной
    public void staffOutWork(List<CheckPointLogRec> checkpointLog, String idStaff) {
        // вначале ищем на текущую дату запись с кодом сотрудника cardStaff в журнале посещений,
        // где поле "dateTimeOut" не заполнео.
        // если не нашли такой записи - ОШИБКА! попал на работу без входа :)
        // если нашли, значит все ок, записываем время выхода с работы в найденную запись
    }

}


