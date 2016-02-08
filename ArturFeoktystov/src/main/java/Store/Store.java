package Store;
import java.sql.*;

public class Store {



    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Controller testController = new Controller();
        AdminView adminView = new AdminView();

        adminView.startMenu();



        //testController.showModels();
    }
}


