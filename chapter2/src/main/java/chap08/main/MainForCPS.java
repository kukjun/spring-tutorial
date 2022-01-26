package chap08.main;

import chap08.config.AppCtx;
import chap08.spring.exception.MemberNotFoundException;
import chap08.spring.exception.WrongIdPasswordException;
import chap08.spring.service.ChangePasswordService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForCPS {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

    ChangePasswordService cps = ctx.getBean("changePasswordService", ChangePasswordService.class);

    try {
      cps.changePassword("kukjun@test.com", "1234", "1111");
      System.out.println("암호 변경 완료");
    } catch (MemberNotFoundException e) {
      System.out.println("회원 데이터가 존재하지 않습니다.");
    } catch (WrongIdPasswordException e) {
      System.out.println("암호가 올바르지 않습니다.");
    }

    ctx.close();
  }
}
