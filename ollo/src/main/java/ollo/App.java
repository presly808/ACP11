package ollo;

import ollo.view.ConsoleView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world! ********
 *
 */
public class App 
{
    public static void main( String[] args ) {

        System.out.println( "Hello ollo! " );

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:app-context.xml");
        ConsoleView view = (ConsoleView) applicationContext.getBean("consoleView");

        view.startView();

    }
}
