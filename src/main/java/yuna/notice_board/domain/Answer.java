package yuna.notice_board.domain;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Answer {
    private Integer id;
    private Integer questionId;
    private String content;
    private LocalDateTime createDate;
}
