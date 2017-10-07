package de.philipppixel.featherwhite.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FeatherWhite {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);

        context.getBean(TextChunkService.class).doSomething();
    }

}
