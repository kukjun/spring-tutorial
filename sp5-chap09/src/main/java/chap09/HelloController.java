package chap09;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 스프링 MVC에서 컨트롤러로 사용
@Controller
public class HelloController {

//    메서드가 처리할 요청 경로를 지정. (GET 요청)
//    /hello 경로로 들어온 요청을 hello()에서 처리
    @GetMapping("/hello")

//    Model 파라미터는 결과를 View에 전달할 때 사용
//    RequestParam 은 HTTP 요청 파라미터의 값을 메서드의 파라미터로 전달할 떄 사용
    public String hello(Model model,
                        @RequestParam(value = "name", required = false) String name) {

//        이 경우 HTTP 요청 파라미터 name 을 메서드의 name 으로 전달
//        데이터 이름을 식별하기 위한 greeting, 속성 이름에 해당하는 값 "안녕하세요, " + name
        model.addAttribute("greeting", "안녕하세요, " + name);
//        처리 결과를 보여줄 View 이름으로 hello 사용
        return "hello";
    }
}
