package chap07.config;

import chap07.calculator.Calculator;
import chap07.calculator.RecCalculator;
import chap07.aspect.ExeTimeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {

  @Bean
  public Calculator calculator() {
    System.out.println("2");
    return new RecCalculator();
  }

  @Bean
  public ExeTimeAspect exeTimeAspect() {
    System.out.println("1");
    return new ExeTimeAspect();
  }



}
