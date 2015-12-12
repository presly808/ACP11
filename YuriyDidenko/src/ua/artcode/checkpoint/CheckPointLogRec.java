package ua.artcode.checkpoint;

import java.util.Date;
import java.util.List;

/**
 * Created by DNK on 12.12.2015.
 */

// Запись в журнале посещений
public class CheckPointLogRec {
    private String idCardStaff;   // код карточки сотрудника
    private Date dateTimeIn;      // время прихода на работу
    private Date dateTimeOut;     // время выхода с работы
    private int idCheckPoint = 1; // номер проходной


    public CheckPointLogRec(String idCardStaff, Date dateTimeIn, Date dateTimeOut) {
        this.idCardStaff = idCardStaff; // idStaff - считываем на выходе код сотрудника при контакте его магнитной карты с картридером на проходной
        this.dateTimeIn = dateTimeIn;   // время прихода на работу
        this.dateTimeOut = dateTimeOut; // время выхода с работы
        //this.idCheckPoint = idCheckPoint; // номер проходной (на будущее :) )
    }

    // возвращаем индекс в массиве последней записи сотрудника в журнале по коду с пустой датой выхода
    public int searchIDStaffDateTimeOutNull(CheckPointLogRec LogRec, DataModule dataModule){
        // обратный цикл от текущего момента в прошлое
        for (int i = dataModule.checkPointLogRecs.size()-1; i >= 0; i--) {
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

    // ВХОД - делаем запись в журнале посещений или сообщаем о ее невозможности
    public void staffWriteTimeInWork(CheckPointLogRec logRec, DataModule dataModule) {
        // вначале ищем, есть ли уже запись с кодом сотрудника cardStaff в журнале посещений
        // где не заполнено поле "dateTimeOut", т.е. время выхода с работы
        // если не заполнено - ошибка! повторный вход без предыдущего выхода...
        // if (logRec.searchIDStaffDateTimeOutNull(CheckPointLogRec logRec, DataModule dataModule) == -1) {}
        // если заполнено или не нашли, значит все ок,
        // создаем новую запись в журнале посещений с открытым полем "dateTimeOut-выход"
        dataModule.checkPointLogRecs.add(logRec);
    }

    // ВЫХОД - делаем запись в журнале посещений или сообщаем о ее невозможности
    public void staffWriteTimeOutWork(CheckPointLogRec logRec, DataModule dataModule) {
        // вначале ищем на текущую дату запись с кодом сотрудника cardStaff в журнале посещений,
        // где поле "dateTimeOut" не заполнено.
        // если не нашли такой записи - ОШИБКА! попал на работу без входа :)

        // если нашли, значит все ок,
        // записываем время выхода с работы в найденную запись
        dataModule.checkPointLogRecs.add(logRec);
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

    public int getIdCheckPoint() {
        return idCheckPoint;
    }
}
