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
    // 글 상세 조회
    public Question findById(Long id){
        String sql = "SELECT id, subject, content, create_date FROM question WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, questionRowMapper(), id);
    }


    public void update(Long id, String subject, String content){
        String sql = "UPDATE question SET subject = ?, content = ? WHERE id = ?";
        jdbcTemplate.update(sql, subject, content, id);
    }

    /**
     * SQL 쿼리를 실행하면 데이터베이스는 테이블 형태의 결과(ResultSet)를 반환합니다
     * 하지만 자바 진영에서는 이 데이터를 다루기 위해 객체(Question 인스턴스)가 필요
     * RowMapper는 ResultSet의 각 행(Row)을 돌며 아래와 같이 데이터베이스의 컬럼 값을 자바 객체에 쏙쏙 집어넣어 주는 번역가 역할
     */
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
