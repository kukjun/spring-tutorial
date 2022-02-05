package config;

import controller.RegisterController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.MemberRegisterService;
import survey.SurveyController;

@Configuration
public class ControllerConfig {

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

}
