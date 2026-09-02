package yuna.notice_board;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
public class Question {
    private Integer id;
    private String subject;
    private String content;
    private LocalDateTime createDate;
}
