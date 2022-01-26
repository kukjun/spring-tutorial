package chap08.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import chap08.spring.exception.DuplicateMemberException;
import chap08.spring.member.Member;
import chap08.spring.dao.MemberDao;
import chap08.spring.request.RegisterRequest;

import java.time.LocalDateTime;

@Component
public class MemberRegisterService {

    @Autowired
    private MemberDao memberDao;

    public Long regist(RegisterRequest req){
        Member member = memberDao.selectByEmail(req.getEmail());
        if(member != null){
            throw new DuplicateMemberException("dup email " + req.getEmail());
        }
        Member newMember = new Member(
                req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now()
        );
        memberDao.insert(newMember);
        return newMember.getId();
    }

}
