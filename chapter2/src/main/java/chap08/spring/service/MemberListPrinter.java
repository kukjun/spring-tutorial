package chap08.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import chap08.spring.dao.MemberDao;
import chap08.spring.member.Member;

import java.util.Collection;

@Component
public class MemberListPrinter {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter printer;

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(m -> printer.print(m));
    }

}
