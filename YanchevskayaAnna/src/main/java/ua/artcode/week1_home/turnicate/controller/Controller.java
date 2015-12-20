package ua.artcode.week1_home.turnicate.controller;

import ua.artcode.week1_home.turnicate.model.*;
import ua.artcode.week1_home.turnicate.model.Date;

import java.util.*;

/**
 * Created by Anna on 05.12.2015.
 */
public class Controller implements OperationController {

    private TurniketDB turniketDB;

    public Controller(TurniketDB turniketDB) {
        this.turniketDB = turniketDB;
    }

    @Override
    public boolean addCard(Integer cardId, String employee) {
        if (turniketDB.getCards().containsKey(cardId)) {
            return false;
        } else {
            turniketDB.getCards().put(cardId, employee);
           // turniketDB.getOperations().put(cardId, null);
            return true;
        }
    }

    @Override
    public boolean deleteCard(Integer cardId) {
        if (turniketDB.getCards().containsKey(cardId)) {
            turniketDB.getCards().remove(cardId);
            turniketDB.getOperations().remove(cardId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String employee(Integer cardId) {
        return turniketDB.getCards().get(cardId);
    }

    public Operation ScanIn(Integer cardId, Date date, Time time) {
        Operation operation = new Operation(cardId, time, TypeOfOperation.IN);

        if (turniketDB.getOperations().containsKey(cardId)) {

            Map<Date, List<Operation>> dateListMap = turniketDB.getOperations().get(cardId);

            if (dateListMap.containsKey(date)) {
                dateListMap.get(date).add(operation);
            } else {
                List<Operation> operations = new ArrayList<>();
                operations.add(operation);
                dateListMap.put(date, operations);
            }

        } else {
            List<Operation> operations = new ArrayList<>();
            operations.add(operation);
            Map<Date, List<Operation>> map = new HashMap<>();
            map.put(date, operations);
            turniketDB.getOperations().put(cardId, map);
        }

        return operation;
    }

    public Operation ScanOut(Integer cardId, Date date, Time time) {
        Operation operation = new Operation(cardId, time, TypeOfOperation.OUT);
        turniketDB.getOperations().get(cardId).get(date).add(operation);
        return operation;
    }

    @Override
    public Time showTotalTime(Integer cardId, Date dateIn, Date DateOut) {
        return null;
    }
}
