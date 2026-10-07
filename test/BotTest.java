import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BotTest {

    private Bot bot;

    @BeforeEach
    void setUp() {
        QuestionStorage storage = new QuestionStorage();
        QuestionGenerator generator = new QuestionGenerator(storage);
        bot = new Bot(generator);
    }

    @Test
    void testBotHandleEmptyInput() {
        String response = bot.handleInput("");
        assertNotNull(response);
    }

    @Test
    void testBotReturnsStringResponse() {
        String response = bot.handleInput("Привет");
        assertNotNull(response);
        assertFalse(response.trim().isEmpty(), "Ответ бота не должен быть пустым");
    }
}
