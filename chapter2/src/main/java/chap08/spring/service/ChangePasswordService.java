package chap08.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import chap08.spring.exception.MemberNotFoundException;
import chap08.spring.member.Member;
import chap08.spring.dao.MemberDao;

@Component
public class ChangePasswordService {

    @Autowired
    private MemberDao memberDao;

    @Transactional
    public void changePassword(String email, String oldPwd, String newPwd) {
        Member member = memberDao.selectByEmail(email);
        if (member == null)
            throw new MemberNotFoundException();

        member.changePassword(oldPwd, newPwd);

        memberDao.update(member);
    }

}
