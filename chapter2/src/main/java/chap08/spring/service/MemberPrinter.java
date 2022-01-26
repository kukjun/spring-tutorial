package chap08.spring.service;

import org.springframework.stereotype.Component;
import chap08.spring.member.Member;

@Component
public class MemberPrinter {

    public void print(Member member){
        System.out.printf(
                "회원 정보: 회원번호=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
                member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime()
        );
    }

}
