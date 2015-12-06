package tourniquet;
import java.util.ArrayList;


public interface IController {


    void addCard (Integer id, String name);
    void scanIn(Card card);
    void scanOut(Card card);
    void addCrad(Integer id, String cardHolder);
    void showAll();



}
