package yuna.notice_board.controller;

// http://localhost:8080/hello와 같은 브라우저의 요청을 처리하려면 먼저 컨트롤러(controller)가 필요
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//HelloController 클래스가 컨트롤러의 기능을 수행한다는 의미. 이 애너테이션이 있어야 스프링 부트 프레임워크가 컨트롤러로 인식
@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello YUNA!";
    }
}
