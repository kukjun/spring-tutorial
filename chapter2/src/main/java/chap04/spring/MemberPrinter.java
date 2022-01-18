package chap04.spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MemberPrinter {

  @Autowired
  private Optional<DateTimeFormatter> formatOpt;

  public void print(Member member) {
    DateTimeFormatter dateTimeFormatter = formatOpt.orElse(null);
    if (dateTimeFormatter == null) {
      System.out.printf(
              "회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
              member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime()
      );

    } else {
      System.out.printf(
              "회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
              member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime())
      );
    }

  }

}
