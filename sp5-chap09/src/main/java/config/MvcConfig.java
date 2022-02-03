package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    prefix + 뷰이름 + suffix 에 해당하는 경로를 뷰 코드로 사용하는 InternalResourceViewResolver 객체 리턴
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("WEB-INF/view/", ".jsp");
    }

}
