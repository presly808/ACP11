package nbstock;

import nbstock.controller.Controller;

import java.sql.SQLException;

/**
 * Created by Dima on 18.01.2016.
 */
public class NBStock {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new Controller();
    }
}
