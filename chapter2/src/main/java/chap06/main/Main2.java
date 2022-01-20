package chap06.main;

import chap06.config.AppCtxWithPrototype;
import chap06.spring.Client;
import chap06.spring.Client2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main2 {

  public static void main(String[] args) {
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithPrototype.class);

    Client2 client2 = ctx.getBean("client2", Client2.class);
    Client2 client2_1 = ctx.getBean("client2", Client2.class);
    Client client = ctx.getBean("client", Client.class);
    Client client_1 = ctx.getBean("client", Client.class);
    System.out.println();

    System.out.print("client, client_1 -> ");
    if (client_1 == client) {
      System.out.println("same Bean");
    } else {
      System.out.println("different Bean");
    }

    System.out.print("client2, client2_1 -> ");
    if (client2_1 == client2) {
      System.out.println("same Bean");
    } else {
      System.out.println("different Bean");
    }

    Client client_2 = ctx.getBean("client", Client.class);
    System.out.println("client_1, client_2 ->");
    if (client_1 == client_2) {
      System.out.println("same Bean");
    } else {
      System.out.println("different Bean");
    }

    System.out.println();
    ctx.close();

  }


}
