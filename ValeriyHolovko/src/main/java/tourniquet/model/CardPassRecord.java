package tourniquet.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 1 on 12.12.2015.
 */
public class CardPassRecord {

    private int month;
    private int day;
    private String passTime;

    boolean inOrOut;       // true - for entering /  false - for out


    public CardPassRecord(boolean inOrOut) {
        SimpleDateFormat dateFormatTime = new SimpleDateFormat("HH:mm:ss");
        passTime = dateFormatTime.format(new Date());

        SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MM");
        String monthStr = dateFormatMonth.format(new Date());
        month = Integer.valueOf(monthStr);

        SimpleDateFormat dateFormatDay = new SimpleDateFormat("dd");
        String dayStr = dateFormatDay.format(new Date());
        day = Integer.valueOf(dayStr);

        this.inOrOut = inOrOut;

        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        //String currentDate = dateFormat.format(new Date());

    }

    @Override
    public String toString() {
        return "CardPassRecord{" +
                "month=" + month +
                ", day=" + day +
                ", passTime='" + passTime + '\'' +
                '}';
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getPassTime() {
        return passTime;
    }

    public boolean isInOrOut() {
        return inOrOut;
    }
}
