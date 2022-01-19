package chap05.config;

import chap05.spring.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"chap05.spring"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "chap05.spring\\..*Dao"))
public class AppCtxWithExclude {
  @Bean
  public MemberDao memberDao() {
    return new MemberDao();
  }

  @Bean
  @Qualifier("printer")
  public MemberPrinter memberPrinter1() {
    return new MemberPrinter();
  }

  @Bean
  @Qualifier("summaryPrinter")
  public MemberSummaryPrinter memberPrinter2() {
    return new MemberSummaryPrinter();
  }

  @Bean
  public MemberRegisterService memberRegSvc() {
    return new MemberRegisterService();
  }

  @Bean
  public ChangePasswordService changePwdSvc() {
    return new ChangePasswordService();
  }

  @Bean
  public MemberListPrinter listPrinter() {
    return new MemberListPrinter();
  }

  @Bean
  public MemberInfoPrinter infoPrinter() {
    MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
    infoPrinter.setPrinter(memberPrinter2());
    return infoPrinter;
  }

  @Bean
  public VersionPrinter versionPrinter() {
    VersionPrinter versionPrinter = new VersionPrinter();
    versionPrinter.setMajorVersion(5);
    versionPrinter.setMinorVersion(0);
    return versionPrinter;
  }
}
