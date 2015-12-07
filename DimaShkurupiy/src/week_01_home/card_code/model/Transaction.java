package week_01_home.card_code.model;

import java.util.Date;

/**
 * Created by Dima on 07.12.2015.
 */
public class Transaction {
    private static int currentId;

    private int id;
    private Card card;
    private CardReader cardReader;
    private long startTime;
    private long duration;

    private Transaction(Card card, CardReader cardReader) {
        this.id = ++currentId;
        this.card = card;
        this.cardReader = cardReader;
        Date currentTime = new Date();
        this.startTime = currentTime.getTime();
        this.duration = 0;
    }

    private Transaction(Card card, CardReader cardReader, long manualTime) {
        this.id = ++currentId;
        this.card = card;
        this.cardReader = cardReader;
        this.startTime = manualTime;
        this.duration = 0;
    }


    public static Transaction StartNewSession(Card card, CardReader cardReader) {
        Transaction newInstance = null;
        if ( cardReader.isOpenToPass() ) {
            if ( card.getSession() == null ) {
                newInstance = new Transaction(card, cardReader);
            } else {
                // TODO drop exception "this card is ALREADY IN"
                // variant - we must find open session and close it.
                System.out.println("this card is ALREADY IN");
                return null;
            }
        } else {
            // TODO drop exception "this cardReader is CLOSED NOW"
            System.out.println("this cardReader is CLOSED NOW");
            return null;
        }

        return newInstance;
    }

    public static Transaction StartNewSessionManual(Card card, CardReader cardReader, long time) {
        Transaction newInstance = null;
        if ( cardReader.isOpenToPass() ) {
            if ( card.getSession() == null ) {
                newInstance = new Transaction(card, cardReader, time);
            } else {
                // TODO drop exception "this card is ALREADY IN"
                // variant - we must find open session and close it.
                System.out.println("this card is ALREADY IN");
                return null;
            }
        } else {
            // TODO drop exception "this cardReader is CLOSED NOW"
            System.out.println("this cardReader is CLOSED NOW");
            return null;
        }

        return newInstance;
    }

    public void close() {
        Date currentTime = new Date();
        this.duration = currentTime.getTime() - startTime;
    }

    public long getDuration() {
        if ( duration > 0 ) return duration;
        Date currentTime = new Date();
        return currentTime.getTime() - startTime;
    }

    public Card getCard() {
        return card;
    }

}
