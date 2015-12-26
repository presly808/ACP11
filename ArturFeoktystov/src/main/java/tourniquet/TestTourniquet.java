package tourniquet;


public class TestTourniquet {

    public static void main(String[] args) {

        CardDB cardDB = new CardDB();
        Controller controller = new Controller(cardDB);


        Card card1 = controller.createCard("Jack");
        Card card2 = controller.createCard("Sam");
        Card card3 = controller.createCard("Don");

//        controller.addCard(card1);
//        controller.addCard(card2);
//        controller.addCard(card3);

//        cardDB.getTime().get(0).add(new Time(2, 4, 1, 0));
//        cardDB.getTime().get(0).add(new Time(3, 4, 1, 0));
//
//        cardDB.getTime().get(1).add(new Time(2, 4, 1, 0));
//        cardDB.getTime().get(1).add(new Time(3, 4, 1, 0));
//
//        cardDB.getTime().get(2).add(new Time(3, 4, 1, 0));
//        cardDB.getTime().get(2).add(new Time(4, 4, 1, 0));

//        controller.showAllCards();
//
//        controller.scanIn(card1);
//        controller.scanOut(card1);




    }

}
