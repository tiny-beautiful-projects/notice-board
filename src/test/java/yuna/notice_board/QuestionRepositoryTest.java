package yuna.notice_board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import yuna.notice_board.repository.QuestionRepository;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
public class QuestionRepositoryTest {

    @Test
    @DisplayName("질문 등록 테스트")
    void testInsert(){
        QuestionRepository repository = new QuestionRepository();
        assertDoesNotThrow(()-> {
            repository.insert("테스트 제목", "테스트 내용"  );
        });

    }

}
