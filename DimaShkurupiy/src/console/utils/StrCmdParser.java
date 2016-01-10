package console.utils;

import console.model.UserOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DNK on 10.01.2016.
 * ��������� ������ �� ������ � ��������� � ����� �������� �������� ���������
 * ���������� ������ �������� ������ UserOrder, �������� ����� ������ ������������ � �� ����������
 */
public class StrCmdParser {

    public ArrayList<UserOrder> parserStrCmd(String strCmdInput) {

        // �������� �������������� ������
        ArrayList<UserOrder> userOrderM = new ArrayList<UserOrder>();
        // �������� ������ ������ � �����������
        String [] strCmd = strCmdInput.split("\\|");
        System.out.println("Count user commands = "+strCmd.length);
        // �������� ������� �� ����������
        for (int i = 0; i < strCmd.length; i++) {
            UserOrder userOrder = new UserOrder();
            String[] strCmdArgs = strCmd[i].split(" ");
            userOrder.setuOrder(strCmdArgs[0]);
            // ������� ������ �� ���� ������� ������, ��� ��� ������ ���� �������, � ������ ����� ���������
            String[] strArgs = new String[strCmdArgs.length - 1];
            for (int j = 0; j < strArgs.length; j++) {
                strArgs[j] = strCmdArgs[j + 1];
            }
            userOrder.setuArgs(strArgs);

            userOrderM.add(userOrder);
        }
        return userOrderM;
    }

    public static void main(String[] args) {

        // �������� ������
        String strCmdInput = "cmd -c |mkdir C:/temp/333|mkdir -f D:/temp/222|dir";
        System.out.println(strCmdInput);

        // �������� �������������� ������
        ArrayList<UserOrder> userOrderM = new ArrayList<UserOrder>();
        // �������� ������ ������ � �����������
        String [] strCmd = strCmdInput.split("\\|");
        System.out.println("Count user commands = "+strCmd.length);
        // �������� ������� �� ����������
        for (int i = 0; i < strCmd.length; i++) {
            UserOrder userOrder = new UserOrder();
            String[] strCmdArgs = strCmd[i].split(" ");
            userOrder.setuOrder(strCmdArgs[0]);
            // ������� ������ �� ���� ������� ������, ��� ��� ������ ���� �������, � ������ ����� ���������
            String[] strArgs = new String[strCmdArgs.length-1];
            for (int j = 0; j < strArgs.length; j++) {
                strArgs[j] = strCmdArgs[j+1];
            }
            userOrder.setuArgs(strArgs);

            userOrderM.add(userOrder);

            System.out.println(userOrder.getuOrder());
            System.out.println(userOrder.toString());

        }
    }
}
