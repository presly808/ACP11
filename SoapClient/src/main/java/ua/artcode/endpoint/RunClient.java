package ua.artcode.endpoint;

/**
 * Created by master on 13.02.16.
 */
public class RunClient {

    public static void main(String[] args) {
        UserService service = new UserServiceImplService().getUserServiceImplPort();
        User user = new User();
        user.setId(43);
        user.setAge(22);
        user.setName("Oleg");
        service.addUser(user);


        User user2 = service.getById(43);

        System.out.printf("%d-%s-%d",user2.getId(),user2.getName(), user2.getAge());
    }
}
