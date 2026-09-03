package yuna.notice_board.repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import yuna.notice_board.domain.Question;

import java.util.List;


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

    // 글 조회
    public List<Question> findAll(){
        String sql = "SELECT id, subject, content, create_date FROM question";
        return jdbcTemplate.query(sql, questionRowMapper());
    }
    private RowMapper<Question> questionRowMapper() {
        return (rs, rowNum) -> {
            System.out.println(">>> rowNum: " + rs);
            Question question = new Question();
            question.setId(rs.getInt("id"));
            question.setSubject(rs.getString("subject"));
            question.setContent(rs.getString("content"));
            if (rs.getTimestamp("create_date") != null) {
                question.setCreateDate(rs.getTimestamp("create_date").toLocalDateTime());
            }
            return question;
        };
    }

}
