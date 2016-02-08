package Store;

import java.util.Scanner;
import java.sql.*;

public class AdminView {


    public void startMenu() throws SQLException{
        Scanner sc = new Scanner(System.in);
        Controller controller = new Controller();

        int choice = -1;
        showMenu();

        while(choice != 5){
            choice = sc.nextInt();

            if(choice == 1){
                showDetails(sc);
            } else if(choice == 2){
                addToTable(sc);
            } else if(choice == 3){
                deleteFromTable(sc);
            } else if(choice == 4){
                controller.selectNotebook(sc);
            } else if(choice == 5){
                System.out.println("See you next time, good luck! :)");
                System.exit(0);
            } else {
                System.out.println("WRONG MENU ITEM");
            }

        }
    }


    public void showMenu(){
        System.out.println("1. Show all details for the specific table:");
        System.out.println("2. Add element from table");
        System.out.println("3. Delete element from table");
        System.out.println("4. Select Notebook");
        System.out.println("5. EXIT from Store");
    }


    public void showDetails(Scanner sc) throws  SQLException{
        System.out.println("Please select which table you want to see:");
        System.out.println("1. Model");
        System.out.println("2. CPU");
        System.out.println("3. HDD");
        System.out.println("4. RAM");
        System.out.println("5. Screen");
        System.out.println("6. Videocard");
        System.out.println("7. EXIT");

        Controller testController = new Controller();

        int choice = -1;

        while(choice != 7) {
            choice = sc.nextInt();

            if (choice == 1) {
                testController.showModels();
            } else if (choice == 2) {
                testController.showCPU();
            } else if (choice == 3) {
                testController.showHDD();
            } else if (choice == 4) {
                testController.showRAM();
            } else if (choice == 5) {
                testController.showScreen();
            } else if (choice == 6) {
                testController.showVideocard();
            } else if (choice == 7) {
                showMenu();
            } else {
                System.out.println("WRONG MENU ITEM");
            }
        }
    }



    public void addToTable(Scanner sc) throws  SQLException{
        System.out.println("Please select into which table you going to ADD details:");
        System.out.println("1. Model");
        System.out.println("2. CPU");
        System.out.println("3. HDD");
        System.out.println("4. RAM");
        System.out.println("5. Screen");
        System.out.println("6. Videocard");
        System.out.println("7. EXIT");

        Controller Controller = new Controller();

        int choice = -1;

        while(choice != 7) {
            choice = sc.nextInt();

            if (choice == 1) {
                Controller.addModels();
            } else if (choice == 2) {
                Controller.addCPU();
            } else if (choice == 3) {
                Controller.addHDD();
            } else if (choice == 4) {
                Controller.addRAM();
            } else if (choice == 5) {
                Controller.addScreen();
            } else if (choice == 6) {
                Controller.addVideocard();
            } else if (choice == 7) {
                showMenu();
            } else {
                System.out.println("WRONG MENU ITEM");
            }
        }
    }



    public void deleteFromTable(Scanner sc) throws  SQLException{
        System.out.println("Please select from which table you going to DELETE details:");
        System.out.println("1. Model");
        System.out.println("2. CPU");
        System.out.println("3. HDD");
        System.out.println("4. RAM");
        System.out.println("5. Screen");
        System.out.println("6. Videocard");
        System.out.println("7. EXIT");

        Controller Controller = new Controller();

        int choice = -1;

        while(choice != 7) {
            choice = sc.nextInt();

            if (choice == 1) {
                Controller.deleteModels();
            } else if (choice == 2) {
                Controller.deleteCPU();
            } else if (choice == 3) {
                Controller.deleteHDD();
            } else if (choice == 4) {
                Controller.deleteRAM();
            } else if (choice == 5) {
                Controller.deleteScreen();
            } else if (choice == 6) {
                Controller.deleteVideocard();
            } else if (choice == 7) {
                showMenu();
            } else {
                System.out.println("WRONG MENU ITEM");
            }
        }
    }

//    public void addProductMenu(Scanner sc){
//        System.out.println("Input bar code");
//        String barCode = sc.next();
//        System.out.println("Input model");
//        String model = sc.next();
//        System.out.println("Input price");
//        double price = sc.nextInt();
//
//        adminController.addProduct(barCode, model, price);
//        System.out.println("Product added");
//
//    }
//
//
//
//    public void findProductMenu(Scanner sc){
//        System.out.println("Input bar code");
//        String barCode = sc.next();
//
//        Product found = adminController.findProductByCode(barCode);
//
//        System.out.println(found);
//    }
//
//
//    public void deleteProductMenu(Scanner sc){
//        System.out.println("Input bar code");
//        String barCode = sc.next();
//        System.out.println("********************");
//        System.out.println("PRODUCT");
//        boolean deleted = adminController.deleteProduct(barCode);
//        System.out.println("deleted " + deleted);
//        System.out.println("********************");
//    }



}

