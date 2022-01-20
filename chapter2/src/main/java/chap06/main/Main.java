package chap06.main;

import chap06.config.AppCtx;
import chap06.spring.Client;
import chap06.spring.Client2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
    Client client = ctx.getBean("client",Client.class);
    Client2 client2 = ctx.getBean("client2", Client2.class);

    System.out.println();

    client.send();
    client2.send();

    System.out.println();
    ctx.close();
  }
}
