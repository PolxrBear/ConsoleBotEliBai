import java.util.Scanner;

public class Main {
    public void main(String[] args) {
        try {
            var storage = new QuestionStorage();
            var generator = new QuestionGenerator(storage);
            var bot = new Bot(generator);
            var scanner = new Scanner(System.in);

            System.out.println(bot.getGreeting());

            while (!bot.isExitRequested()) {
                var input = scanner.nextLine();
                var response = bot.handleInput(input);
                System.out.println(response);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
