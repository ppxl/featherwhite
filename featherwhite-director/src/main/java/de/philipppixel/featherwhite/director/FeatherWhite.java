package de.philipppixel.featherwhite.director;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import de.philipppixel.featherwhite.core.app.TextChunkService;
import de.philipppixel.featherwhite.core.app.PersistenceContext;

public class FeatherWhite {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);

        context.getBean(TextChunkService.class).doSomething();
    }

}
