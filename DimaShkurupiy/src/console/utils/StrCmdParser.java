package console.utils;

import console.model.UserOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DNK on 10.01.2016.
 * –азбивает строку на строки с командами и потом выдел€ет отдельно агрументы
 * возвращает массив объектов класса UserOrder, хран€щий набор команд пользовател€ и их аргументов
 */
public class StrCmdParser {

    public ArrayList<UserOrder> parserStrCmd(String strCmdInput) {

        // объ€вили результирующий массив
        ArrayList<UserOrder> userOrderM = new ArrayList<UserOrder>();
        // получаем массив команд с параметрами
        String [] strCmd = strCmdInput.split("\\|");
        System.out.println("Count user commands = "+strCmd.length);
        // отдел€ем команды от параметров
        for (int i = 0; i < strCmd.length; i++) {
            UserOrder userOrder = new UserOrder();
            String[] strCmdArgs = strCmd[i].split(" ");
            userOrder.setuOrder(strCmdArgs[0]);
            // создаем массив на одни Їлемент меньше, так как первой идет команда, а только потом аргументы
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

        // тестова€ строка
        String strCmdInput = "cmd -c |mkdir C:/temp/333|mkdir -f D:/temp/222|dir";
        System.out.println(strCmdInput);

        // объ€вили результирующий массив
        ArrayList<UserOrder> userOrderM = new ArrayList<UserOrder>();
        // получаем массив команд с параметрами
        String [] strCmd = strCmdInput.split("\\|");
        System.out.println("Count user commands = "+strCmd.length);
        // отдел€ем команды от параметров
        for (int i = 0; i < strCmd.length; i++) {
            UserOrder userOrder = new UserOrder();
            String[] strCmdArgs = strCmd[i].split(" ");
            userOrder.setuOrder(strCmdArgs[0]);
            // создаем массив на одни Їлемент меньше, так как первой идет команда, а только потом аргументы
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
