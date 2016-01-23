package nbstock.model;

import java.sql.Connection;

/**
 * Created by Dima on 18.01.2016.
 */
public class NBSMainDB {
    private Connection db;

    public NBSMainDB(Connection db) {
        this.db = db;
    }
}
