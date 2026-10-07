import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuestionStorageTest {

    @Test
    void testQuestionCreation() {
        Question q = new Question("Франция", "Париж");
        assertEquals("Париж", q.getAnswer());
        assertEquals("Франция", q.getQuestion());
    }

    @Test
    void testStorageIsNotEmpty() {
        QuestionStorage storage = new QuestionStorage();
        assertNotNull(storage.getQuestions(), "Список вопросов не должен быть null");
        assertFalse(storage.getQuestions().isEmpty(), "Хранилище вопросов не должно быть пустым");
    }
}
