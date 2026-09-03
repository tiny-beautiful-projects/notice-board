package yuna.notice_board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import yuna.notice_board.domain.Question;
import yuna.notice_board.repository.QuestionRepository;

import java.util.List;
import java.util.Scanner;

@Controller
public class QuestionController {
    private final QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    @GetMapping("/")
    public String questionList(Model model){
        List<Question> questionList = questionRepository.findAll();
        // 템플릿을 사용하기 때문에 해당 파일의 이름을 작성한다.
        model.addAttribute("questionList", questionList);
        return "index";
    }
}
