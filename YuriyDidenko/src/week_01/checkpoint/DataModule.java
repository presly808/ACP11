package ua.artcode.checkpoint;

import java.util.HashMap;

/**
 * Created by DNK on 06.12.2015.
 */
public class DataModule {
    public HashMap<String, CardStaff> staffDB = new HashMap<String, CardStaff>();
    CardStaff s1 = new CardStaff("Ivanov", "Petr");
    CardStaff s2 = new CardStaff("Rebrenko", "Ivan");
    CardStaff s3 = new CardStaff("Dub", "Semen");
    CardStaff s4 = new CardStaff("Antonenko", "Elena");

    staffDB.put("001", s1);

}
