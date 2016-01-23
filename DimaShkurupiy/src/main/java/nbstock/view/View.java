package nbstock.view;

import nbstock.controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Dima on 18.01.2016.
 */
public class View {
    private Controller controller;

    private static final String NEW_COMPONENTS_MENU = "Add new product component";
    private static final String NEW_PRODUCT_TYPE_MENU = "Add new product type";
    private static final String PUT_PRODUCTS_TO_STOCK = "Put products to stock";
    private static final String GET_PRODUCTS_FROM_STOCK = "Get products from stock";
    private static final String STOCK_REPORTS_MENU = "Stock reports menu";
    private static final String STOCK_OPERATION_REPORTS_MENU = "Stock operation reports menu";
    private static final String NEW_MODEL = "Add new model";
    private static final String NEW_CPU = "Add new cpu";
    private static final String NEW_HDD = "Add new hdd";
    private static final String NEW_MEMORY = "Add new memory";
    private static final String NEW_VIDEO = "Add new video controller";
    private static final String NEW_DISPLAY = "Add new display";
    private static final String MAIN_MENU = "Main menu";
//    private static final String xxx = "";
//    private static final String xxx = "";
//    private static final String xxx = "";
//    private static final String xxx = "";
//    private static final String xxx = "";

    public View(Controller controller) throws SQLException {
        this.controller = controller;
        mainMenu();
    }


    public int showMenu(String ... str) {
        Scanner sc = new Scanner(System.in);

        int i=1;
        System.out.println(0 + ". Exit");
        for (String s : str) {
            System.out.println(i++ + ". " + s);
        }
        System.out.println("Your choice: ");

        return sc.nextInt();
    }

    public void mainMenu() throws SQLException {
        switch (showMenu(
                NEW_COMPONENTS_MENU,
                NEW_PRODUCT_TYPE_MENU,
                PUT_PRODUCTS_TO_STOCK,
                GET_PRODUCTS_FROM_STOCK,
                STOCK_REPORTS_MENU,
                STOCK_OPERATION_REPORTS_MENU
                        )) {
            case 1:
                componentsMenu();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
            default:
                System.exit(999);
                break;
        }
        mainMenu();
    }

    public void componentsMenu() throws SQLException {
        switch (showMenu(
                NEW_MODEL,
                NEW_CPU,
                NEW_HDD,
                NEW_MEMORY,
                NEW_VIDEO,
                NEW_DISPLAY,
                MAIN_MENU
                        )) {
            case 1:
                break;
            case 2:
                controller.newCpu();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                mainMenu();
                break;
            case 0:
            default:
                System.exit(999);
                break;
        }
    }

/*    public void mainMenu() {
        switch (showMenu(

                         )) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
            default:
                System.exit(999);
                break;
        }
    }
*/
}
