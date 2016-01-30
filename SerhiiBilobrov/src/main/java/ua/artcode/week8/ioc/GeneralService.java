package ua.artcode.week8.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by serhii on 30.01.16.
 */
@Component
public class GeneralService implements Service {

    @Autowired
    @Qualifier("generalDao")
    private Dao dao;

    public GeneralService() {
    }

    public GeneralService(Dao dao) {
        this.dao = dao;
    }

    public String doService(){
        return dao.data();
    }

}
