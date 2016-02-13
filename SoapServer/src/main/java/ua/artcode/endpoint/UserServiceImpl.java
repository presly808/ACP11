package ua.artcode.endpoint;

import ua.artcode.model.User;

import javax.jws.WebService;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebService(endpointInterface = "ua.artcode.endpoint.UserService")
public class UserServiceImpl implements UserService {

    private final Map<Integer,User> userMap = new ConcurrentHashMap<>();

    @Override
    public boolean addUser(User user) {
        userMap.put(user.getId(), user);
        return true;
    }

    @Override
    public User getById(int id) {
        return userMap.get(id);
    }

}
