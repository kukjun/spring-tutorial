package chap08.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import chap08.spring.dao.MemberDao;
import chap08.spring.member.Member;

@Component
public class MemberInfoPrinter {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter memberPrinter;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            System.out.println("데이터 없음\n");
            return;
        }
        memberPrinter.print(member);
        System.out.println();
    }

}
