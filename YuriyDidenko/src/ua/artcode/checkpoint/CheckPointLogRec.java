package ua.artcode.checkpoint;

import java.util.Date;
import java.util.List;

/**
 * Created by DNK on 12.12.2015.
 */

// ������ � ������� ���������
public class CheckPointLogRec {
    private String idCardStaff;   // ��� �������� ����������
    private Date dateTimeIn;      // ����� ������� �� ������
    private Date dateTimeOut;     // ����� ������ � ������
    private int idCheckPoint = 1; // ����� ���������


    public CheckPointLogRec(String idCardStaff, Date dateTimeIn, Date dateTimeOut) {
        this.idCardStaff = idCardStaff; // idStaff - ��������� �� ������ ��� ���������� ��� �������� ��� ��������� ����� � ����������� �� ���������
        this.dateTimeIn = dateTimeIn;   // ����� ������� �� ������
        this.dateTimeOut = dateTimeOut; // ����� ������ � ������
        //this.idCheckPoint = idCheckPoint; // ����� ��������� (�� ������� :) )
    }

    // ���������� ������ � ������� ��������� ������ ���������� � ������� �� ���� � ������ ����� ������
    public int searchIDStaffDateTimeOutNull(CheckPointLogRec LogRec, DataModule dataModule){
        // �������� ���� �� �������� ������� � �������
        for (int i = dataModule.checkPointLogRecs.size()-1; i >= 0; i--) {
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

    // ���� - ������ ������ � ������� ��������� ��� �������� � �� �������������
    public void staffWriteTimeInWork(CheckPointLogRec logRec, DataModule dataModule) {
        // ������� ����, ���� �� ��� ������ � ����� ���������� cardStaff � ������� ���������
        // ��� �� ��������� ���� "dateTimeOut", �.�. ����� ������ � ������
        // ���� �� ��������� - ������! ��������� ���� ��� ����������� ������...
        //if (LogRec.searchIDStaffDateTimeOutNull(CheckPointLogRec LogRec, DataModule dataModule) == -1) {}
        // ���� ��������� ��� �� �����, ������ ��� ��,
        // ������� ����� ������ � ������� ��������� � �������� ����� "dateTimeOut-�����"
        dataModule.checkPointLogRecs.add(logRec);
    }

    // ����� - ������ ������ � ������� ��������� ��� �������� � �� �������������
    public void staffWriteTimeOutWork(CheckPointLogRec logRec, DataModule dataModule) {
        // ������� ���� �� ������� ���� ������ � ����� ���������� cardStaff � ������� ���������,
        // ��� ���� "dateTimeOut" �� ���������.
        // ���� �� ����� ����� ������ - ������! ����� �� ������ ��� ����� :)

        // ���� �����, ������ ��� ��,
        // ���������� ����� ������ � ������ � ��������� ������
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
