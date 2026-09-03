package yuna.notice_board.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuestionRepository {

    private final String url = "jdbc:mysql://localhost:3306/notice_board?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final String user = "root";
    private final String password = "istj!@#06207191";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

   // 글 등록
    public void insert(String subject, String content){
        String sql = "INSERT INTO question (subject, content, create_date) VALUES (?, ?, NOW())";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, subject);
            pstmt.setString(2, content);
            pstmt.executeUpdate();
            System.out.println(">>> [MySQL] 글 등록 성공!");
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
