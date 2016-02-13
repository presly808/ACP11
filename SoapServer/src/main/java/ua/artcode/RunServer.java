package ua.artcode;

import ua.artcode.endpoint.UserServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by master on 13.02.16.
 */
public class RunServer {
    public static void main(String[] args) {
        Endpoint.publish("http://192.168.1.40:9999/ws/user",new UserServiceImpl());
    }
}
