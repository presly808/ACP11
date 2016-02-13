package ua.artcode.jersey.endpoint;


import ua.artcode.jersey.model.User;

import javax.ws.rs.*;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Path("/user")
public class UserEndpoint {


    private final Map<Integer,User> userMap = new ConcurrentHashMap<>();

    public UserEndpoint() {
        userMap.put(1, new User(1,"Ivan",30));
    }

    @Path(value = "/add")
    @POST
    @Consumes("application/json")
    public boolean addUser(User user) {
        userMap.put(user.getId(), user);
        return true;
    }

    @Path("/hello")
    @GET
    public String hello(@QueryParam("name") String name){
        return "hello " + name + " " + new Date();
    }

    //
    @Path(value = "/get/{id}")
    @GET
    @Produces("application/json")
    public User getById(@PathParam("id") int id) {
        return userMap.get(id);
    }

}
