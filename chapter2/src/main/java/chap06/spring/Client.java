package chap06.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class Client implements InitializingBean, DisposableBean {

  private String host;

  public void setHost(String host) {
    System.out.println("hello");
    this.host = host;
  }

  @Autowired
  public void setClient2(Client2 client2) {
    System.out.println("world");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("Client.afterPropertiesSet() 실행");
  }

  public void send() {
    System.out.println("Client.send() to " + host);
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("Client.destroy() 실행");
  }

}
