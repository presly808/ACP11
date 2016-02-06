package ollo.view;

import java.util.Scanner;

/**
 * Created by Dima on 31.01.2016.
 */
public class ConsoleView implements IView{
    private Scanner sc;

    private final static String EXIT = "0. Exit";
    private final static String YOUR_CHOICE = "your choice: ";
    private final static String LOGIN_MENU = "Login";
    private final static String REGISTER_MENU = "Registration / New user";
    private final static String VIEW_ADS_MENU = "View advertesing messages";
    private final static String LOGIN = "login:";
    private final static String PASSWORD = "password:";
    private final static String WRONG_LOGIN = "Wrong login/password or no such user in system";
/*    private final static String = "";
    private final static String = "";
    private final static String = "";
    private final static String = "";
    private final static String = "";
    private final static String = "";
    private final static String = "";
    private final static String = "";
    private final static String = "";
    private final static String = "";
    private final static String = "";
    private final static String = "";
    private final static String = "";
    private final static String = "";*/

    public ConsoleView() {
        this.sc = new Scanner(System.in);
    }

    public void startView() {
        mainMenu();
    }

    private int showMenu(String...items) {
        System.out.println(EXIT);

        int i = 1;
        for(String menuItem : items) {
            System.out.println(i++ + ". " + menuItem);
        }

        System.out.println(YOUR_CHOICE);

        return sc.nextInt();
    }

    private String readLabeledInput(String label) {
        System.out.println(label);

        return sc.next(); //nextLine();
    }

    private void mainMenu() {
        switch(
                showMenu(
                        LOGIN_MENU,             //1
                        REGISTER_MENU,          //2
                        VIEW_ADS_MENU   )) {    //3
            case 1:
                loginMenu();
                break;
            case 2:
                registerMenu();
                break;
            case 3:
                viewAdsMenu();
                break;
            case 0:
            default:
                System.exit(999);
                break;
        }
    }

    private void viewAdsMenu() {
        System.out.println("view ads menu here");
    }

    private void registerMenu() {
        String login = readLabeledInput(LOGIN);
        String password = readLabeledInput(PASSWORD);

        //call cotroller REGISTER case to: 1) make new user in system, 3) back to main menu => Str msg: success or user exist

        // System.out.println(____ String registerResult__________);
        mainMenu();

    }

    private void loginMenu() {
        String login = readLabeledInput(LOGIN);
        String password = readLabeledInput(PASSWORD);

        //call cotroller login case to: 1) call admin view, 2) call user view, 3) back to main menu

        System.out.println(WRONG_LOGIN);
        mainMenu();
    }

}
