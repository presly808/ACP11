package week_01_home.card_code.controller;

import week_01_home.card_code.model.Application;
import week_01_home.card_code.model.Card;
import week_01_home.card_code.model.CardReader;
import week_01_home.card_code.model.Transaction;
import week_01_home.card_code.view.AppView;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Dima on 07.12.2015.
 */
public class AppController {
    Application app = new Application();
    AppView view;

    public AppController() {
        this.view = new AppView(this);
    }

    public void showAllCards(){
        List<Card> cards = app.getCards();
        for(Card card : cards) {
            System.out.println(card.toString());
        }
    }

    public void showCardsIn(){
        List<Card> cards = app.getCards();
        for(Card card : cards) {
            if( card.getSession() != null ) {
                System.out.println(card.toString());
            }
        }
    }

    private Card getCardById(int id) {
        List<Card> cards = app.getCards();
        for(Card card : cards) {
            if( card.getId() == id ) {
                return card;
            }
        }
        return null;
    }

    private CardReader getCardReaderById(int id) {
        List<CardReader> cardReaders = app.getCardReaders();
        for(CardReader cardReader : cardReaders) {
            if( cardReader.getId() == id ) {
                return cardReader;
            }
        }
        return null;
    }

    // TODO <T> Два одинаковых метода для разных типов. как прикрутить дженерик?
    /*
    private <T> getInstanceById(int id) {

    }
    */

    public void showCardById(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input card ID: ");
        int id = sc.nextInt();

        Card card = getCardById(id);
        if( card != null ) {
            System.out.println(card.toString());
            return;
        }

        System.out.println("Can`t find card #" + id);
    }

    public void closeCardReaderById(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input card reader ID to close: ");
        int id = sc.nextInt();

        CardReader cardReader = getCardReaderById(id);
        if( cardReader != null ) {
            System.out.println(cardReader.toString());
            cardReader.close();
            System.out.println(cardReader.toString());
            return;
        }

        System.out.println("Can`t find cardReader #" + id);
    }

    public void openCardReaderById(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input card reader ID to open: ");
        int id = sc.nextInt();

        CardReader cardReader = getCardReaderById(id);
        if( cardReader != null) {
            System.out.println(cardReader.toString());
            cardReader.open();
            System.out.println(cardReader.toString());
            return;
        }

        System.out.println("Can`t find cardReader #" + id);
    }

    public void showAllCardReaders(){
        List<CardReader> cardReaders = app.getCardReaders();
        for(CardReader cardReader : cardReaders) {
            System.out.println(cardReader.toString());
        }
    }

    public void addCard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input name: ");
        String name = sc.nextLine();
        app.createCard(name);
    }

    public void addCardReader() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input note: ");
        String note = sc.nextLine();
        app.createCardReader(note);
    }

    public void scanCard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input card reader ID: ");
        int cardReaderId = sc.nextInt();
        System.out.print("Input card ID: ");
        int cardId = sc.nextInt();

        app.touchTransaction(getCardById(cardId), getCardReaderById(cardReaderId));
    }

    public void showBestCard() {
        List<Transaction> sessions = app.getTransactions();
        List<Card> cards = app.getCards();
        long[] totalCardTime = new long[cards.size()];

        for(Transaction transaction : sessions) {
            totalCardTime[ transaction.getCard().getId() ] += transaction.getDuration();
        }

        int maxIndex = 0;
        for (int i = 1; i < totalCardTime.length ; i++) {
            if( totalCardTime[maxIndex] < totalCardTime[i] ) maxIndex = i;
        }

        System.out.println("The best card is:");
        System.out.println(getCardById(maxIndex).toString());
        System.out.println("and total work time (hrs): " + totalCardTime[maxIndex]/(1000*60*60));
    }

    // Fill DB with DEMO DATA
    public void initTestData() {
        app.createCardReader("door_1, CR_1"); //1
        app.createCardReader("door_1, CR_2"); //2
        app.createCardReader("door_1, CR_3"); //3
        app.createCardReader("door_2, CR_1"); //4
        app.createCardReader("door_2, CR_2"); //5
        app.createCardReader("door_3, CR_1"); //6

        app.createCard("Dima");   //1
        app.createCard("Yura");   //2
        app.createCard("Anya");   //3
        app.createCard("Slava");  //4
        app.createCard("Valera"); //5
        app.createCard("Serhiy"); //6
        app.createCard("Vasya");  //7
        app.createCard("Masha");  //8

        // 1449511300000

        app.touchTransactionManual(app.getCards().get(1), app.getCardReaders().get(1), 1449511300000L );
        app.touchTransactionManual(app.getCards().get(1), app.getCardReaders().get(1), 1449511303600L );

        app.touchTransactionManual(app.getCards().get(1), app.getCardReaders().get(3), 1449511310000L );
        app.touchTransactionManual(app.getCards().get(1), app.getCardReaders().get(1), 1449511313600L );

        app.touchTransactionManual(app.getCards().get(1), app.getCardReaders().get(1), 1449511320000L );
        app.touchTransactionManual(app.getCards().get(1), app.getCardReaders().get(4), 1449511333600L );

        app.touchTransactionManual(app.getCards().get(1), app.getCardReaders().get(1), 1449511340000L );
        app.touchTransactionManual(app.getCards().get(1), app.getCardReaders().get(1), 1449511343600L );

        app.touchTransactionManual(app.getCards().get(1), app.getCardReaders().get(3), 1449511350000L );
        app.touchTransactionManual(app.getCards().get(1), app.getCardReaders().get(1), 1449511373600L );

        app.touchTransactionManual(app.getCards().get(2), app.getCardReaders().get(1), 1449511300000L );
        app.touchTransactionManual(app.getCards().get(2), app.getCardReaders().get(1), 1449511303600L );

        app.touchTransactionManual(app.getCards().get(2), app.getCardReaders().get(1), 1449511310000L );
        app.touchTransactionManual(app.getCards().get(2), app.getCardReaders().get(1), 1449511313600L );

        app.touchTransactionManual(app.getCards().get(2), app.getCardReaders().get(2), 1449511320000L );
        app.touchTransactionManual(app.getCards().get(2), app.getCardReaders().get(1), 1449511333600L );

        app.touchTransactionManual(app.getCards().get(2), app.getCardReaders().get(1), 1449511340000L );
        app.touchTransactionManual(app.getCards().get(2), app.getCardReaders().get(5), 1449511343600L );

        app.touchTransactionManual(app.getCards().get(2), app.getCardReaders().get(1), 1449511350000L );
        //app.touchTransactionManual(app.getCards().get(2), app.getCardReaders().get(1), 1449511373600L );


    }
}
