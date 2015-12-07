package week_01_home.card_code.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dima on 07.12.2015.
 */
public class Application {
    List<Card> cards = new ArrayList<Card>();
    List<CardReader> cardReaders = new ArrayList<CardReader>();
    List<Transaction> transactions = new ArrayList<Transaction>();

    public Application() {
    }

    public boolean createCard(String name){
        int cardsBefore = cards.size();
        Card newCard = new Card(name);

        if ( newCard != null ) {
            cards.add(newCard);
        } else {
            // drop exception "can`t create new card"
        }
        if( cardsBefore == cards.size() ) {
            // drop exception "can`t add new card to cards list"
        }

        return true;
    }

    public boolean createCardReader(String note) {
        int cardReadersBefore = cardReaders.size();
        CardReader newCardReader = new CardReader(note);

        if ( newCardReader != null ) {
            cardReaders.add(newCardReader);
        } else {
            // drop exception "can`t create new cardReader"
        }
        if( cardReadersBefore == cardReaders.size() ) {
            // drop exception "can`t add new cardReader to cards list"
        }

        return true;
    }

    public void touchTransaction(Card card, CardReader cardReader) {
        Transaction transaction = card.getSession();
        if (  transaction == null ) {
            transaction = Transaction.StartNewSession(card, cardReader);
            transactions.add(transaction);
            card.setSession(transaction);               // mark card as CARD_IN by save open session pointer in card
        } else {
            transaction.close();
            card.setSession(null);
        }
    }

    public void touchTransactionManual(Card card, CardReader cardReader,long time) {
        Transaction transaction = card.getSession();
        if (  transaction == null ) {
            transaction = Transaction.StartNewSessionManual(card, cardReader, time);
            transactions.add(transaction);
            card.setSession(transaction);               // mark card as CARD_IN by save open session pointer in card
        } else {
            transaction.close();
            card.setSession(null);
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<CardReader> getCardReaders() {
        return cardReaders;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
