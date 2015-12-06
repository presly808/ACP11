package tourniquet;


public class Controller implements IController {


    @Override
    public void addCard(Integer id, String name) {

    }

    private CardDB cardDB;


    @Override
    public void scanIn(Card card){

    }

    @Override
    public void scanOut(Card card){

    }

    @Override
    public void addCrad(Integer id, String cardHolder){
        Card card = new Card(id, cardHolder);

    }

    @Override
    public void showAll(){

    }




}
