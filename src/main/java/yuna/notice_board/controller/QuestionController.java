package yuna.notice_board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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


    // 게시판 첫 화면 (질문 목록 조회)
    @GetMapping("/")
    public String questionList(Model model){
        List<Question> questionList = questionRepository.findAll();
        // 템플릿을 사용하기 때문에 해당 파일의 이름을 작성한다.
        model.addAttribute("questionList", questionList);
        // templates/index.html을 의미
        return "index";
    }

    // 질문 등록 처리
    @PostMapping("/question/create") // 클라이언트로부터 /question/create 주소로 들어오는 HTTP POST 요청을 이 메서드와 연결(매핑)
    // ResponseBody: 메서드가 리턴하는 값("success")을 타임리프 같은 HTML 뷰 파일 이름으로 인식하지 않고, 문자열 데이터 그 자체를 HTTP 응답 본문(Body)에 담아 클라이언트(브라우저)로 바로 전달합니다.
    // 화면 이동 없이 결과를 주고받는 AJAX 통신에서 필수적인 어노테이션
    @ResponseBody
    public String createQuestion(@RequestParam("subject") String subject, @RequestParam("content") String content){
        questionRepository.insert(subject, content);
        return "success";
    }


}
