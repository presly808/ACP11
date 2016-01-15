package tourniquet;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Controller {

    private Database database;
    int count; //number of cards created so far

    public Controller(Database database) {
        this.database = database;
    }

    public Card createCard(String name){
        return new Card(name,count++);
    }

    public Card addNew(Card card){
        if (database.getCards().size() > card.getId()){
            throw new RuntimeException("Such card already exist");
        }
        database.getCards().add(card);
        database.getTimeTracking().add(new ArrayList<TimeTracking>());
        return card;
    }

    public void scanIn(Card card){
        ArrayList<TimeTracking> times = database.getTimeTracking().get(card.getId());
        TimeTracking lastTimeTracking = times.get(times.size()-1);

        Calendar calendar = new GregorianCalendar();
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        if (isTheSameDay(card,month,day)){
            if (lastTimeTracking.getEntrance() != 0){
                throw new RuntimeException("This card has already entered");
            } else {
                Date date = new Date();
                lastTimeTracking.setEntrance(date.getTime());
            }
        } else {
            TimeTracking newTimeTracking = new TimeTracking(day,month,0,0);
            times.add(newTimeTracking);
            Date date = new Date();
            newTimeTracking.setEntrance(date.getTime());
        }
    }

    public void scanOut(Card card){
        ArrayList<TimeTracking> times = database.getTimeTracking().get(card.getId());
        TimeTracking lastTimeTracking = times.get(times.size()-1);

        Calendar calendar = new GregorianCalendar();
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        if (lastTimeTracking.getEntrance() == 0){
            throw new RuntimeException("This card hasn't entered yet");
        } else {
            Date date = new Date();
            lastTimeTracking.setTotalTime(lastTimeTracking.getTotalTime()+(date.getTime() - lastTimeTracking.getEntrance()));
            lastTimeTracking.setEntrance(0);
        }
    }

    public Card findBestWorker(int month){
        Card bestCard;
        int bestCardNumber = 0;
        int totalHours = 0;
        for (Card card : database.getCards()){
            if (calculateWorkHours(card,month,0,month,31) > totalHours){
                bestCardNumber = card.getId();
                totalHours = calculateWorkHours(card,month,0,month,31);
            }
        }
        bestCard = database.getCards().get(bestCardNumber);
        System.out.printf("Best worker during the %d month is %s\n",month,bestCard.getName());
        return bestCard;
    }

    public int calculateWorkHours(Card card, int startMonth, int startDay, int endMonth, int endDay){
        int totalHours = 0;
        ArrayList<TimeTracking> times = database.getTimeTracking().get(card.getId());
        for (TimeTracking timeTracking : times){
            int month = timeTracking.getMonth();
            int day = timeTracking.getDay();
            if ((month > startMonth || (month == startMonth && day>=startDay)) &&
                    (month < endMonth || (month == endMonth && day <= endDay))){
                totalHours += timeTracking.getTotalTime();
            }
        }
        return totalHours;
    }

    public void showWorkHoursBetweenDates(Card card, int startMonth, int startDay, int endMonth, int endDay){
        int totalHours = calculateWorkHours(card,startMonth, startDay, endMonth, endDay);
        System.out.printf("%s worked %d hours at the period %d.%d - %d.%d\n",card.getName(),totalHours,
                startDay,startMonth,endDay,endMonth);
    }

    public void showAll(){
        for (Card card : database.getCards()){
            System.out.println(card.getId() + " : " + card.getName());
        }
    }

    private boolean isTheSameDay (Card card, int month, int day){
        ArrayList<TimeTracking> times = database.getTimeTracking().get(card.getId());
        TimeTracking lastTimeTracking = times.get(times.size()-1);
        if (month > lastTimeTracking.getMonth()){
            return false;
        } else {
            if (day > lastTimeTracking.getDay()){
                return false;
            }
        }
        return true;
    }


}
