import java.util.Random;

public class QuestionGenerator {
    private QuestionStorage storage;
    private Random random;

    public QuestionGenerator(QuestionStorage storage) {
        this.storage = storage;
        this.random = new Random();
    }

    public Question getRandomQuestion() {
        if (storage.getQuestions().isEmpty()) {
            return new Question("Нет вопросов", "");
        }
        int randomIndex = random.nextInt(storage.size());
        return storage.getQuestion(randomIndex);
    }
}
