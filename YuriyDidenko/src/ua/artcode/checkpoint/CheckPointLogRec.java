package ua.artcode.checkpoint;

import java.util.Date;
import java.util.List;

/**
 * Created by DNK on 12.12.2015.
 */

// Запись в журнале посещений
public class CheckPointLogRec {
    String idCardStaff; // код карточки сотрудника
    Date dateTimeIn;    // время прихода на работу
    Date dateTimeOut;   // время выхода с работы
    int idCheckPoint;   // номер проходной


    public CheckPointLogRec(String idCardStaff, Date dateTimeIn, Date dateTimeOut, int idCheckPoint) {
        this.idCardStaff = idCardStaff;
        this.dateTimeIn = dateTimeIn;
        this.dateTimeOut = dateTimeOut;
        this.idCheckPoint = idCheckPoint;
    }

    // возвращаем индекс в массиве последней записи сотрудника в журнале по коду с пустой датой выхода
    public int searchIDStaffDateTimeOutNull(CheckPointLogRec LogRec, DataModule dataModule){
        // обратный цикл от текущего момента в прошлое
        for (int i = dataModule.checkPointLogRecs.size()-1; i >= 0; i--) {
            // наш сотрудник
            if (dataModule.checkPointLogRecs.get(i).getIdCardStaff() == LogRec.idCardStaff) {
                //if (checkpointLog.get(i).getDateTimeIn().equals(new Date(System.currentTimeMillis())))
                // время выхода пустое
                if (dataModule.checkPointLogRecs.get(i).getDateTimeOut() == null) {
                    return i;
                }
            }
        }
        return -1; // запись не найдена с пустой датой выхода
    }

    // idStaff - считываем на входе код сотрудника при контакте его магнитной карты с картридером на проходной
    public void staffWriteTimeInWork(CheckPointLogRec LogRec, DataModule dataModule){
        // вначале ищем, есть ли уже запись с кодом сотрудника cardStaff в журнале посещений
        // где не заполнено поле "dateTimeOut", т.е. время выхода с работы
        // если не заполнено - ошибка! повторный вход без предыдущего выхода...
        //if (LogRec.searchIDStaffDateTimeOutNull(CheckPointLogRec LogRec, DataModule dataModule) == -1) {}
        // если заполнено или не нашли, значит все ок, создаем новую запись в журнале посещений с открытым полем "dateTimeOut-выход"
    }

    // idStaff - считываем на выходе код сотрудника при контакте его магнитной карты с картридером на проходной
    public void staffWriteTimeOutWork(CheckPointLogRec LogRec, DataModule dataModule) {
        // вначале ищем на текущую дату запись с кодом сотрудника cardStaff в журнале посещений,
        // где поле "dateTimeOut" не заполнено.
        // если не нашли такой записи - ОШИБКА! попал на работу без входа :)

        // если нашли, значит все ок, записываем время выхода с работы в найденную запись
    }

    public void setIdCardStaff(String idCardStaff) {
        this.idCardStaff = idCardStaff;
    }

    public void setDateTimeIn(Date dateTimeIn) {
        this.dateTimeIn = dateTimeIn;
    }

    public void setDateTimeOut(Date dateTimeOut) {
        this.dateTimeOut = dateTimeOut;
    }

    public String getIdCardStaff() {
        return idCardStaff;
    }

    public Date getDateTimeIn() {
        return dateTimeIn;
    }

    public Date getDateTimeOut() {
        return dateTimeOut;
    }
}
