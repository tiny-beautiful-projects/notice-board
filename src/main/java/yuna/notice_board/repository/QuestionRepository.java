package yuna.notice_board.repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class QuestionRepository {
    private final JdbcTemplate jdbcTemplate;

    // 스프링이 JdbcTemplate을 자동으로 주입해 줍니다.
    public QuestionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 글 등록
    public void insert(String subject, String content) {
        String sql = "INSERT INTO question (subject, content, create_date) VALUES (?, ?, NOW())";
        jdbcTemplate.update(sql, subject, content);
    }

}
