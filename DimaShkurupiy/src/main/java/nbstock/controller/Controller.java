package nbstock.controller;

import nbstock.model.*;
import nbstock.model.product.Cpu;
import nbstock.view.View;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Dima on 18.01.2016.
 */
public class Controller {
    private NBSMainDB mainDB;
    private View view;
    private Connection db;

    public Controller() throws SQLException, ClassNotFoundException {
        this.db = DBGate.getConnection();
        this.mainDB = new NBSMainDB(db);
        this.view = new View(this);
    }

    public void newCpu() throws SQLException {
        Cpu.cpuFactory(db,"intel",1500);
    }

}
