package spring.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.Application;

public class TestcONFIG {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(Application.class);

    }
}
