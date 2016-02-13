package ua.artcode.endpoint;

import ua.artcode.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Collection;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {


    @WebMethod
    boolean addUser(User user);

    @WebMethod
    User getById(int id);




}
