package config;

import controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;
import survey.SurveyController;

@Configuration
public class ControllerConfig {

    @Autowired
    private MemberRegisterService memberRegisterService;
    @Autowired
    private AuthService authService;
    @Autowired
    private ChangePasswordService changePasswordService;
    @Autowired
    private MemberDao memberDao;


    @Bean
    public RegisterController registerController() {
        System.out.println("check RegisterController");
        return new RegisterController();
    }

    @Bean
    public SurveyController surveyController() {
        System.out.println("check SurveyController");
        return new SurveyController();
    }

    @Bean
    public LoginController loginController() {
        LoginController controller = new LoginController();
        controller.setAuthService(authService);
        return controller;
    }

    @Bean
    public LogoutController logoutController() {
        LogoutController controller = new LogoutController();
        return controller;
    }

    @Bean
    public ChangePwdController changePwdController() {
        ChangePwdController controller = new ChangePwdController();
        controller.setChangePasswordService(changePasswordService);
        return controller;
    }

    @Bean
    public MemberListController memberListController() {
        MemberListController controller = new MemberListController();
        controller.setMemberDao(memberDao);
        return controller;
    }

    @Bean
    public MemberDetailController memberDetailController() {
        MemberDetailController controller = new MemberDetailController();
        controller.setMemberDao(memberDao);
        return controller;
    }

    @Bean
    public CommonExceptionHandler commonExceptionHandler() {
        CommonExceptionHandler handler = new CommonExceptionHandler();
        return handler;
    }

    @Bean
    public RestMemberController restMemberController() {
        RestMemberController controller = new RestMemberController();
        controller.setMemberDao(memberDao);
        controller.setRegisterService(memberRegisterService);
        return controller;
    }

}
