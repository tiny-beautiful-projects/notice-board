package yuna.notice_board;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TableInitializer {
    private final JdbcTemplate jdbcTemplate;

    public TableInitializer(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        initTables();
    }

    private void initTables(){
        String createQuestionTable = "CREATE TABLE IF NOT EXISTS question (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "subject VARCHAR(255) NOT NULL, " +
                "content TEXT NOT NULL, " +
                "create_date TIMESTAMP NOT NULL)";
        String createAnswerTable = "CREATE TABLE IF NOT EXISTS answer (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "question_id INT NOT NULL, " +
                "content TEXT NOT NULL, " +
                "create_date TIMESTAMP NOT NULL, " +
                "FOREIGN KEY (question_id) REFERENCES question(id))";
        jdbcTemplate.execute(createQuestionTable);
        jdbcTemplate.execute(createAnswerTable);
    }
}
