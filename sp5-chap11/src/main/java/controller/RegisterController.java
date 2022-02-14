package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @RequestMapping("/register/step1")
    public String handleStep1() {
        System.out.println("success");
        return "register/step1";
    }

    @PostMapping("/register/step2")
    public String handleStep2(
            @RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model
    ) {
        if (!agree) {
            return "register/step1";
        }
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register/step2";
    }

    @GetMapping("/register/step2")
    public String handleStep2Get() {
        return "redirect:/register/step1";
    }

    private MemberRegisterService memberRegisterService;

    @Autowired
    public void setMemberRegisterService(
            MemberRegisterService memberRegisterService
    ) {
        this.memberRegisterService = memberRegisterService;
    }

    @PostMapping("/register/step3")
    public String handleStep3(@Valid RegisterRequest regReq, Errors errors) {
        if (errors.hasErrors()) {
            return "register/step2";
        }
        try {
            memberRegisterService.regist(regReq);
            return "register/step3";
        } catch (DuplicateMemberException ex) {
            errors.rejectValue("email", "duplicated");
            return "register/step2";
        }
    }

}
