package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import spring.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestMemberController {
    private MemberDao memberDao;
    private MemberRegisterService registerService;

    @GetMapping("/api/members")
    public List<Member> members() {
        return memberDao.selectAll();
    }

//    @GetMapping("/api/members/{id}")
//    public Member member(@PathVariable Long id, HttpServletResponse response) throws IOException {
//        Member member = memberDao.selectById(id);
//        if (member == null) {
//            response.sendError(HttpServletResponse.SC_NOT_FOUND);
//            return null;
//        }
//        return member;
//    }

    @GetMapping("/api/members/{id}")
    public ResponseEntity<Object> member(@PathVariable Long id){
        Member member = memberDao.selectById(id);
        if (member == null) {
            throw new MemberNotFoundException();
        }
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @PostMapping("/api/members")
    public ResponseEntity<Object> newMember(
            @RequestBody @Valid RegisterRequest regReq,
            Errors errors) {
        if (errors.hasErrors()) {
            String errorCodes = errors.getAllErrors() // List<ObjectError
                    .stream()
                    .map(error -> error.getCodes()[0])
                    .collect(Collectors.joining(","));
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("errorCodes = " + errorCodes));
        }
        try {
            Long newMemberId = registerService.regist(regReq);
            return ResponseEntity
                    .ok().body("success");
        } catch (DuplicateMemberException dupEx) {
            throw new DuplicateMemberException();
        }
    }


    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void setRegisterService(MemberRegisterService registerService) {
        this.registerService = registerService;
    }


    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoData() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("no member"));
    }

    @ExceptionHandler(DuplicateMemberException.class)
    public ResponseEntity<ErrorResponse> handleDuplicatedData() {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse("duplicated member"));
    }
}
