package ollo;

import ollo.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dima on 01.02.2016.
 */
public class OlloStart {
    public static void main( String[] args ) {

        System.out.println( "Hello ollo! " );

        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:app-context.xml");
        Controller app = appContext.getBean(Controller.class);

        app.startView();

    }
}
