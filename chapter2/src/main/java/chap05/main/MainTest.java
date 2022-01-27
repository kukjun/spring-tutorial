package chap05.main;

import chap05.config.AppCtx;
import chap05.spring.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppCtx.class);

        appCtx.getBean("test", Test.class);
        System.out.println();
    }
}
