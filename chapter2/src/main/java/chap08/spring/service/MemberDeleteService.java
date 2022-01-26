package chap08.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import chap08.spring.dao.MemberDao;
import chap08.spring.exception.MemberNotFoundException;
import chap08.spring.exception.WrongIdPasswordException;
import chap08.spring.member.Member;

@Component
public class MemberDeleteService {

    @Autowired
    private MemberDao memberDao;

    @Transactional
    public void deleteUser(String email, String password) {
        Member member = memberDao.selectByEmail(email);
        if (member == null)
            throw new MemberNotFoundException();
        else if (!member.getPassword().equals(password))
            throw new WrongIdPasswordException();

        memberDao.delete(member);
    }

}
