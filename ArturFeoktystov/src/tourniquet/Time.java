package tourniquet;


public class Time {

    private int day;
    private int month;
    private long timeCurDay;
    private long lastTime;

    public Time(int day, int month, long timeCurDay, long lastTime) {
        this.day = day;
        this.month = month;
        this.timeCurDay = timeCurDay;
        this.lastTime = lastTime;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getTimeCurDay() {
        return timeCurDay;
    }

    public void setTimeCurDay(long timeCurDay) {
        this.timeCurDay = timeCurDay;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public long getTotalTime() {
        return timeCurDay;
    }

    public long getEntrance() {
        return lastTime;
    }

    public void setTotalTime(long totalTime) {
        this.timeCurDay = totalTime;
    }

    public void setEntrance(long entrance) {
        this.lastTime = entrance;
    }



}
