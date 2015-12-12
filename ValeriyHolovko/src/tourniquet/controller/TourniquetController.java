package tourniquet.controller;

import tourniquet.model.Card;
import tourniquet.model.CardPassRecord;
import tourniquet.model.TourniquetDB;

import java.util.ArrayList;

/**
 * Created by 1 on 05.12.2015.
 */
public class TourniquetController implements iTourniquetController {

    private TourniquetDB db;

    public TourniquetController(TourniquetDB db) {
        this.db = db;
    }

    @Override
    public Card registerNew(Integer cardNumber, String ownerName) throws CardAlreadyExistsException{

        Card newCard = new Card(cardNumber,ownerName);

        if (!db.getCardsAbilityToEnter().containsKey(newCard)) {
            db.getCardsAbilityToEnter().put(newCard, true);
            db.getCardsPass().put(newCard,new ArrayList<>());
            return newCard;
        }
        throw new CardAlreadyExistsException(String.format("Card #%d already exists in DB",cardNumber));
    }

    @Override
    public void scanIn(Card card) throws CardIsAlreadyInException{

        if (db.getCardsAbilityToEnter().containsKey(card) && db.getCardsAbilityToEnter().get(card)){
            db.getCardsAbilityToEnter().put(card,false);
            db.getCardsPass().get(card).add(new CardPassRecord(true));

        } else {
            throw new CardIsAlreadyInException(String.format("Card #%d is already in",card.getNumber()));
        }

    }

    @Override
    public void scanOut(Card card) throws CardIsNotInException{
        if (db.getCardsAbilityToEnter().containsKey(card) && !db.getCardsAbilityToEnter().get(card)){
            db.getCardsAbilityToEnter().put(card,true);
            db.getCardsPass().get(card).add(new CardPassRecord(false));

        } else {
            throw new CardIsNotInException(String.format("Card #%d is not in",card.getNumber()));
        }
    }

    @Override
    public String showAllCards() throws NoCardsException{

        String cardsString = db.getCardsAbilityToEnter().toString();

        if (cardsString.length() == 0){
            throw new NoCardsException("No cards in DB");
        }
        return cardsString;
    }

    @Override
    public String showCurrentIns() {

        // I need to override method keySet in CardsTreeMap in order to obtain Set<K>
        // and then check value true/false by each key and show those cards which are false
        return null;
    }

    @Override
    public String showPassTime(Card card, int day, int month) {

        String currentDayPassTime = "";

        ArrayList<CardPassRecord> allPassData = db.getCardsPass().get(card);

        for (CardPassRecord cardPassRecord : allPassData){
            if (cardPassRecord.getMonth() == month && cardPassRecord.getDay() == day){
                currentDayPassTime += cardPassRecord.toString() + "\n";
            }
        }

        return currentDayPassTime;


    }

    @Override
    public String showHistoryOfPass(Card card) {

        String passes = "";

        ArrayList<CardPassRecord> allPassData = db.getCardsPass().get(card);

        for (CardPassRecord cardPassRecord : allPassData){
            passes += cardPassRecord.toString() + "\n";
        }

        return passes;
    }


    public String showWorkingTime (Card card, int month, int day){

        Integer currentDayWorkTime = 0;

        ArrayList<CardPassRecord> allPassData = db.getCardsPass().get(card);

        for (CardPassRecord cardPassRecord : allPassData){
            if (cardPassRecord.getMonth() == month && cardPassRecord.getDay() == day && !cardPassRecord.isInOrOut()){

                CardPassRecord lastOut = cardPassRecord;
                CardPassRecord lastIn = allPassData.get(allPassData.indexOf(cardPassRecord) - 1);

                Integer sumInSeconds = oneEntranceWorkTimeInSeconds(lastIn, lastOut);
                currentDayWorkTime += sumInSeconds;

            }
        }

        return fromWorkTimeInSecToString(currentDayWorkTime);

    }

    public String showWorkingTime (Card card, int month){


        Integer currentMonthWorkTime = 0;

        ArrayList<CardPassRecord> allPassData = db.getCardsPass().get(card);

        for (CardPassRecord cardPassRecord : allPassData){
            if (cardPassRecord.getMonth() == month && !cardPassRecord.isInOrOut()){

                CardPassRecord lastOut = cardPassRecord;
                CardPassRecord lastIn = allPassData.get(allPassData.indexOf(cardPassRecord) - 1);

                Integer sumInSeconds = oneEntranceWorkTimeInSeconds(lastIn, lastOut);

                currentMonthWorkTime += sumInSeconds;


            }
        }

        return fromWorkTimeInSecToString(currentMonthWorkTime);

    }




    private Integer oneEntranceWorkTimeInSeconds(CardPassRecord lastIn, CardPassRecord lastOut){

        String[] lastOutTime = lastOut.getPassTime().split(":");
        String[] lastInTime = lastIn.getPassTime().split(":");

        Integer inHour = Integer.valueOf(lastInTime[0]);
        Integer inMinutes = Integer.valueOf(lastInTime[1]);
        Integer inSeconds = Integer.valueOf(lastInTime[2]);

        Integer outHour = Integer.valueOf(lastOutTime[0]);
        Integer outMinutes = Integer.valueOf(lastOutTime[1]);
        Integer outSeconds = Integer.valueOf(lastOutTime[2]);



        Integer seconds = outSeconds - inSeconds;
        if (seconds < 0){
            outMinutes -= 1;
            seconds = 60 - seconds;
        }

        Integer minutes = (outMinutes - inMinutes) * 60;
        if (minutes < 0){
            outHour -= 1;
            minutes = 60 * 60 - minutes;
        }

        Integer hours = (outHour - inHour) * 3600;

        return hours + minutes + seconds;

    }

    private String fromWorkTimeInSecToString(Integer timeInSeconds){

        Integer hours = timeInSeconds / 3600;
        Integer minutes = (timeInSeconds % 3600) / 60;
        Integer seconds = (timeInSeconds % 3600) % 60;

        return String.format("%d:%d:%d",hours,minutes,seconds);
    }



}
