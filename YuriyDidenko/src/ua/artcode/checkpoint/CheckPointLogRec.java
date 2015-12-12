package ua.artcode.checkpoint;

import java.util.Date;

/**
 * Created by DNK on 12.12.2015.
 */

// ������ � ������� ���������
public class CheckPointLogRec {
    String idCardStaff; // ��� �������� ����������
    Date dateTimeIn;  // ����� ������� �� ������
    Date dateTimeOut; // ����� ������ � ������
    int idCheckPoint; // ����� ���������

    public CheckPointLogRec(String idCardStaff, Date dateTimeIn, Date dateTimeOut, int idCheckPoint) {
        this.idCardStaff = idCardStaff;
        this.dateTimeIn = dateTimeIn;
        this.dateTimeOut = dateTimeOut;
        this.idCheckPoint = idCheckPoint;
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
