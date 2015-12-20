package ua.artcode.week1_home.turnicate.model;

/**
 * Created by Anna on 06.12.2015.
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int  day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public int compareTo(Date date) {
        if (this.year > date.year) {
            return 1;
        } else if (this.year < date.year) {
            return -1;
        } else {
            if (this.month > date.month) {
                return 1;
            } else if (this.month < date.month) {
                return -1;
            } else {
                if (this.day > date.day) return 1;
                else if (this.day > date.day) return -1;
                else return 0;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;

        Date date = (Date) o;

        if (day != date.day) return false;
        if (month != date.month) return false;
        if (year != date.year) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        return result;
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
