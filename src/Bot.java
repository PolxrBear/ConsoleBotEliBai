public class Bot {
    private QuestionGenerator generator;
    private Question currentQuestion;
    private boolean isExitRequested;

    public Bot(QuestionGenerator generator) {
        this.generator = generator;
        this.currentQuestion = generator.getRandomQuestion();
        this.isExitRequested = false;
    }

    public String getGreeting() {
        return "Привет! Я бот, который проверяет знание столиц.\n" +
                "Задаю вопрос — ты отвечаешь.\n" +
                "[ \\help - справка ]\n[ \\stop - остановка бота ]\n\n" +
                currentQuestion.getQuestion();
    }

    public String getHelp() {
        return "[ \\help - справка ]\n[ \\stop - остановка бота]\n\n" +
                currentQuestion.getQuestion();
    }

    public String handleInput(String input) {
        if (input == null) {
            return "";
        }

        String trimmedInput = input.trim();

        if (trimmedInput.equalsIgnoreCase("\\help")) {
            return getHelp();
        }

        if (trimmedInput.equalsIgnoreCase("\\stop")) {
            this.isExitRequested = true;
            return "Пока!";
        }

        String result;
        if (currentQuestion.checkAnswer(trimmedInput)) {
            result = "Правильно!";
        } else {
            result = "Ты ошибся. Правильный ответ: " + currentQuestion.getAnswer();
        }

        currentQuestion = generator.getRandomQuestion();
        return result + "\n\n" + currentQuestion.getQuestion();
    }

    public boolean isExitRequested() {
        return isExitRequested;
    }
}
