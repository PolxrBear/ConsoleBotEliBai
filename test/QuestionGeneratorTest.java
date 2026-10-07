import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuestionGeneratorTest {

    @Test
    void testGetRandomQuestionReturnsValidQuestion() {
        QuestionStorage storage = new QuestionStorage();
        QuestionGenerator generator = new QuestionGenerator(storage);

        Question question = generator.getRandomQuestion();

        assertNotNull(question, "Генератор должен возвращать вопрос");
        assertNotNull(question.getAnswer(), "У вопроса должна быть столица");
        assertNotNull(question.getQuestion(), "У вопроса должна быть страна");
    }
}
