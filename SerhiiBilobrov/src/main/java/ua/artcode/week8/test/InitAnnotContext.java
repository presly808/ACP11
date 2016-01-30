package ua.artcode.week8.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.artcode.week8.ioc.View;

/**
 * Created by serhii on 30.01.16.
 */
public class InitAnnotContext {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ua.artcode.week8");
        View view = context.getBean(View.class);

        view.show();
    }

}
