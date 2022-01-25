package chap07.main;

import chap07.calculator.Calculator;
import chap07.calculator.RecCalculator;
import chap07.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

    // 수정전
//    Calculator cal = ctx.getBean("calculator", Calculator.class);

    // 수정후
    Calculator cal = ctx.getBean("calculator", RecCalculator.class);
    long fiveFact = cal.factorial(5);
    System.out.println("cal.factorial(5) = " + fiveFact);
    System.out.println(cal.getClass().getName());
    ctx.close();
  }
}
