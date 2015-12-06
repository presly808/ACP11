package week1_home.turnicate.controller;

import week1_home.turnicate.model.*;

/**
 * Created by Anna on 06.12.2015.
 */
public interface OperationController {

    boolean addCard(Integer cardId, String employee);
    boolean deleteCard(Integer cardId);

    String employee(Integer cardId);

    Operation ScanIn(Integer cardId, Date date, Time time);

    Operation ScanOut(Integer cardId, Date date, Time time);

    Time showTotalTime(Integer cardId, Date dateIn, Date DateOut);


}
