package tourniquet;


import java.sql.Time;

public class TimeTracking {
    private int day;
    private int month;
    private long totalTime; //total time spent in the office on current day
    private long entrance; //time of last entrance

    public TimeTracking(int day, int month, long totalTime, long entrance) {
        this.day = day;
        this.month = month;
        this.totalTime = totalTime;
        this.entrance = entrance;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public long getEntrance() {
        return entrance;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public void setEntrance(long entrance) {
        this.entrance = entrance;
    }
}
