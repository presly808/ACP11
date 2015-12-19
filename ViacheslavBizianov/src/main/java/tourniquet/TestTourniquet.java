package tourniquet;


public class TestTourniquet {
    public static void main(String[] args) {
        Database database = new Database();
        Controller controller = new Controller(database);

        Card ivan = controller.createCard("Ivan");
        Card petr = controller.createCard("Petr");
        Card alex = controller.createCard("Alex");
        Card bob = controller.createCard("Bob");
        controller.addNew(ivan);
        controller.addNew(petr);
        controller.addNew(alex);
        controller.addNew(bob);

        database.getTimeTracking().get(0).add(new TimeTracking(1,12,8,0));
        database.getTimeTracking().get(0).add(new TimeTracking(2,12,8,0));
        database.getTimeTracking().get(1).add(new TimeTracking(2,12,8,0));
        database.getTimeTracking().get(1).add(new TimeTracking(3,12,8,0));
        database.getTimeTracking().get(1).add(new TimeTracking(4,12,8,0));
        database.getTimeTracking().get(2).add(new TimeTracking(3,12,8,0));
        database.getTimeTracking().get(2).add(new TimeTracking(5,12,8,0));
        database.getTimeTracking().get(3).add(new TimeTracking(3,12,8,0));

        controller.showAll();

        controller.scanIn(ivan);
        controller.scanOut(ivan);

        controller.showWorkHoursBetweenDates(ivan,11,2,12,31);
        controller.findBestWorker(12);

    }
}
