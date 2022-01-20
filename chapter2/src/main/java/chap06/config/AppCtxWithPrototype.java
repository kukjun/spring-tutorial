package chap06.config;

import chap06.spring.Client;
import chap06.spring.Client2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtxWithPrototype {

  @Bean
  @Scope("prototype")
  public Client client() {
    Client client = new Client();
    client.setHost("host");
    return client;
  }

  @Bean(initMethod = "connect", destroyMethod = "close")
  @Scope("singleton")
  public Client2 client2() {
    Client2 client2 = new Client2();
    client2.setHost("host");
    return client2;
  }
}
