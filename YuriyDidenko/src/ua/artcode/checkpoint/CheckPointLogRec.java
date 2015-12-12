package ua.artcode.checkpoint;

import java.util.Date;
import java.util.List;

/**
 * Created by DNK on 12.12.2015.
 */

// ������ � ������� ���������
public class CheckPointLogRec {
    String idCardStaff; // ��� �������� ����������
    Date dateTimeIn;    // ����� ������� �� ������
    Date dateTimeOut;   // ����� ������ � ������
    int idCheckPoint;   // ����� ���������


    public CheckPointLogRec(String idCardStaff, Date dateTimeIn, Date dateTimeOut, int idCheckPoint) {
        this.idCardStaff = idCardStaff;
        this.dateTimeIn = dateTimeIn;
        this.dateTimeOut = dateTimeOut;
        this.idCheckPoint = idCheckPoint;
    }

    // ���������� ������ � ������� ��������� ������ ���������� � ������� �� ���� � ������ ����� ������
    public int searchIDStaffDateTimeOutNull(CheckPointLogRec LogRec, DataModule dataModule){
        // �������� ���� �� �������� ������� � �������
        for (int i = dataModule.checkPointLogRecs.size()-1; i >= 0; i--) {
            // ��� ���������
            if (dataModule.checkPointLogRecs.get(i).getIdCardStaff() == LogRec.idCardStaff) {
                //if (checkpointLog.get(i).getDateTimeIn().equals(new Date(System.currentTimeMillis())))
                // ����� ������ ������
                if (dataModule.checkPointLogRecs.get(i).getDateTimeOut() == null) {
                    return i;
                }
            }
        }
        return -1; // ������ �� ������� � ������ ����� ������
    }

    // idStaff - ��������� �� ����� ��� ���������� ��� �������� ��� ��������� ����� � ����������� �� ���������
    public void staffWriteTimeInWork(CheckPointLogRec LogRec, DataModule dataModule){
        // ������� ����, ���� �� ��� ������ � ����� ���������� cardStaff � ������� ���������
        // ��� �� ��������� ���� "dateTimeOut", �.�. ����� ������ � ������
        // ���� �� ��������� - ������! ��������� ���� ��� ����������� ������...
        //if (LogRec.searchIDStaffDateTimeOutNull(CheckPointLogRec LogRec, DataModule dataModule) == -1) {}
        // ���� ��������� ��� �� �����, ������ ��� ��, ������� ����� ������ � ������� ��������� � �������� ����� "dateTimeOut-�����"
    }

    // idStaff - ��������� �� ������ ��� ���������� ��� �������� ��� ��������� ����� � ����������� �� ���������
    public void staffWriteTimeOutWork(CheckPointLogRec LogRec, DataModule dataModule) {
        // ������� ���� �� ������� ���� ������ � ����� ���������� cardStaff � ������� ���������,
        // ��� ���� "dateTimeOut" �� ���������.
        // ���� �� ����� ����� ������ - ������! ����� �� ������ ��� ����� :)

        // ���� �����, ������ ��� ��, ���������� ����� ������ � ������ � ��������� ������
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
