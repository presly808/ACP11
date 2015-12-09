package tourniquet;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Controller {

    private CardDB database;
    int cardID;


    //-------------------------------- DataBase---------------------
    public Controller(CardDB database) {
        this.database = database;
    }

    //-----------------------------------------------------
    public Card createCard(String cardHolder) {
        return new Card(cardID++, cardHolder);
    }

    //-----------------------------------------------------
    public Card addCard(Card card) {
        if (database.getCards().size() > card.getCardID()) System.out.println("Card with this ID already exist");
        //throw new RuntimeException("Card with this ID already exist");
        database.getCards().add(card);
        database.getTime().add(new ArrayList<Time>());
        return card;
    }


    //-------------------------------- Scan ---------------------
    public void scanIn(Card card) {
        ArrayList<Time> times = database.getTime().get(card.getCardID());
        Time lastTime = times.get(times.size() - 1);

        //work with Calendar
        Calendar calendar = new GregorianCalendar();
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        if (isTheSameDay(card, month, day)) {
            if (lastTime.getEntrance() != 0) {
                throw new RuntimeException("This card has already entered");
            } else {
                Date date = new Date();
                lastTime.setEntrance(date.getTime());
            }
        } else {
            Time newTimeTracking = new Time(day, month, 0, 0);
            times.add(newTimeTracking);
            Date date = new Date();
            newTimeTracking.setEntrance(date.getTime());
        }
    }

    //-----------------------------------------------------
    public void scanOut(Card card) {

        ArrayList<Time> times = database.getTime().get(card.getCardID());
        Time lastTime = times.get(times.size()-1);

        Calendar calendar = new GregorianCalendar();
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        if (lastTime.getEntrance() == 0){
            throw new RuntimeException("This card hasn't entered yet");
        } else {
            Date date = new Date();
            lastTime.setTotalTime(lastTime.getTotalTime()+(date.getTime() - lastTime.getEntrance()));
            lastTime.setEntrance(0);
        }

    }


    //-------------------------------- Show ---------------------
    public void showAllCards() {
        for (Card card : database.getCards())
            System.out.println(card.getCardID() + " - " + card.getCardHolder());
    }

    //-----------------------------------------------------
    public void showBestWorkers() {

    }

    //-----------------------------------------------------
    public void showHoursPerDays() {

    }


    private boolean isTheSameDay(Card card, int month, int day) {
        ArrayList<Time> times = database.getTime().get(card.getCardID());
        Time lastTime = times.get(times.size() - 1);

        if (month > lastTime.getMonth()) {
            return false;
        } else {
            if (day > lastTime.getDay()) {
                return false;
            }
        }
        return true;

    }
}