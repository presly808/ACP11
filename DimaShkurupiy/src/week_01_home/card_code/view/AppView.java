package week_01_home.card_code.view;

import week_01_home.card_code.controller.AppController;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Dima on 07.12.2015.
 */
public class AppView {
    private AppController ac;

    private static final String MENU = "Menu:";
    private static final String CHOICE = "Please, make your choice:";
    private static final String EXIT = "0. Exit";

    private static final String ADDCARD = "add card";
    private static final String SHOWCARDS = "show all cards";
    private static final String SHOWCARDSIN = "show all cards inside";
    private static final String SHOWCARD = "show card by ID";
    private static final String SHOWBESTCARD = "show best card";

    private static final String ADDCARDREADER = "add card reader";
    private static final String SHOWCARDREADERS = "show all card reders";
    private static final String OPENCARDREADER = "open card reder by ID";
    private static final String CLOSECARDREADER = "close card reder by ID";

    private static final String INITDATA = "Init test data";
    private static final String SHOWLINUXTIME = "Show linux time ( millis from 1970 )";
    private static final String SCANCARD = "Scan card !!!";

    public AppView(AppController ac) {
        this.ac = ac;
        mainMenu();
    }

    private int showMenu(String... items) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" ");
        System.out.println(MENU);
        int i = 1;
        for(String item : items) {
            System.out.println(i++ + ". " + item);
        }
        System.out.println(EXIT);
        System.out.print(CHOICE);
        System.out.println(" ");

        return sc.nextInt();
    }

    private void mainMenu() {
        switch (
            showMenu(ADDCARD, SHOWCARDS, SHOWCARDSIN, SHOWCARD, SHOWBESTCARD,
                    ADDCARDREADER, SHOWCARDREADERS, OPENCARDREADER, CLOSECARDREADER,
                    INITDATA, SHOWLINUXTIME, SCANCARD)
                ) {
            case 1:
                ac.addCard();
                break;
            case 2:
                ac.showAllCards();
                break;
            case 3:
                ac.showCardsIn();
                break;
            case 4:
                ac.showCardById();
                break;
            case 5:
                ac.showBestCard();
                break;
            case 6:
                ac.addCardReader();
                break;
            case 7:
                ac.showAllCardReaders();
                break;
            case 8:
                ac.openCardReaderById();
                break;
            case 9:
                ac.closeCardReaderById();
                break;
            case 10:
                ac.initTestData();
                break;
            case 11:
                Date d = new Date();
                System.out.println(d.getTime());
                break;
            case 12:
                ac.scanCard();
                break;
            case 0:
            default:
                return;
        }
        mainMenu();
    }
}
