package tourniquet.controller;

import tourniquet.model.Card;

/**
 * Created by 1 on 05.12.2015.
 */
public interface iTourniquetController {

    Card registerNew(Integer cardNumber, String ownerName) throws CardAlreadyExistsException;
    void scanIn(Card card) throws CardIsAlreadyInException;
    void scanOut(Card card) throws CardIsNotInException;
    String showAllCards() throws NoCardsException;
    String showCurrentIns();
    String showPassTime(Card card, int day, int month);
    String showHistoryOfPass(Card card);
    String showWorkingTime (Card card, int month, int day);
    String showWorkingTime (Card card, int month);


    class CardAlreadyExistsException extends Exception {
        public CardAlreadyExistsException(String message) {
            super(message);
        }
    }

    class CardIsAlreadyInException extends Exception {
        public CardIsAlreadyInException(String message) {
            super(message);
        }
    }

    class CardIsNotInException extends Exception {
        public CardIsNotInException(String message) {
            super(message);
        }
    }

    class NoCardsException extends Exception {
        public NoCardsException(String message) {
            super(message);
        }
    }
}
