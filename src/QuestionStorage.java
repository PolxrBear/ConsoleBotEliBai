import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuestionStorage {
    private List<Question> questions;

    public QuestionStorage() {
        this.questions = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("capitals.txt"));

            for (String line : lines) {
                if (line.contains(":")) {
                    String[] parts = line.split("\\s*:\\s*", 2);

                    String country = parts[0].trim();
                    String capital = parts[1].trim();

                    String questionText = "<| " + country + " |>";
                    questions.add(new Question(questionText, capital));
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при чтении capitals.txt: " + e.getMessage());
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int size() {
        return questions.size();
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }
}
