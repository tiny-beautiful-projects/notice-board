package yuna.notice_board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {

    @GetMapping("/")
    public String questionList(){
        // 템플릿을 사용하기 때문에 해당 파일의 이름을 작성한다.
        return "index";
    }
}
