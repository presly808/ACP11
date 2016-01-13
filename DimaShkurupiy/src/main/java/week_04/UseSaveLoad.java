package week_04;

/**
 * Created by Dima on 26.12.2015.
 */
public class UseSaveLoad {
    public static void main(String[] args) {
        User user = new User("Vasya","+380973334455",new Car("Zhigul",1980));

        try {
            System.out.println(SaveObject.saveObj(user));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        ;
    }
}
