package ua.artcode.week8.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.week8.ioc.Service;
import ua.artcode.week8.ioc.View;

/**
 * Created by serhii on 30.01.16.
 */
public class InitContext {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:week8/ioc/app-context.xml");

        View view1 = (View) applicationContext.getBean("view");

        View view2 = applicationContext.getBean(View.class);

        View view3 = applicationContext.getBean("view",View.class);

        Service service = applicationContext.getBean(Service.class);


        view1.show();
        view2.show();
        view3.show();

        View myView = new View();
        myView.show();


    }

}
