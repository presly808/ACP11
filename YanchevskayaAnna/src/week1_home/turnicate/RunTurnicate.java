package week1_home.turnicate;

import  week1_home.turnicate.controller.Controller;
import  week1_home.turnicate.model.*;

/**
 * Created by Anna on 06.12.2015.
 */
public class RunTurnicate {

    public static void main(String[] args) {

        TurniketDB turniketDB = new TurniketDB();
        Controller controller = new Controller(turniketDB);
        controller.addCard(1, "Тюхта А.");
        controller.addCard(2, "Савицкая Л.");
        controller.addCard(3, "Крищенко О.");

        Date beforeYesterday = new Date(2015, 12, 4);
        Date yesterday = new Date(2015, 12, 5);

        Time timeIn = new Time(10, 15);
        Time timeOut = new Time(18, 15);

        controller.ScanIn(1, beforeYesterday, timeIn);
        controller.ScanIn(2, beforeYesterday, timeIn);
        controller.ScanIn(3, beforeYesterday, timeIn);
        controller.ScanOut(1, beforeYesterday, timeOut);
        controller.ScanOut(2, beforeYesterday, timeOut);
        controller.ScanOut(3, beforeYesterday, timeOut);

        controller.ScanIn(1, yesterday, timeIn);
        controller.ScanIn(2, yesterday, timeIn);
        controller.ScanIn(3, yesterday, timeIn);
        controller.ScanOut(1, yesterday, timeOut);
        controller.ScanOut(2, yesterday, timeOut);
        controller.ScanOut(3, yesterday, timeOut);

        controller.ScanIn(1, yesterday, new Time(18, 20));
        controller.ScanOut(1, yesterday, new Time(19, 20));
        controller.ScanIn(2, yesterday, new Time(18, 30));
        controller.ScanOut(2, yesterday, new Time(20, 30));

        //нужен итератор
        for (Integer idCard : turniketDB.getCards().keySet()) {
            System.out.println("total time of " + controller.employee(idCard) + " " + controller.showTotalTime(idCard, beforeYesterday, yesterday));
        }

    }
}
