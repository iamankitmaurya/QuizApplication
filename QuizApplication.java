import java.util.*;

// Class to represent a quiz question
class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public QuizQuestion(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrectAnswer(int selectedOptionIndex) {
        return selectedOptionIndex == correctOptionIndex;
    }
}

// Main Quiz Application class
public class QuizApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static List<QuizQuestion> quizQuestions = new ArrayList<>();
    private static int score = 0;

    public static void main(String[] args) {
        initializeQuizQuestions();
         
        System.out.println("Welcome your in codsoft project");
        System.out.println("Welcome to the Quiz!");

        // Present each question one at a time
        for (int i = 0; i < quizQuestions.size(); i++) {
            QuizQuestion question = quizQuestions.get(i);
            presentQuestion(question, i + 1);
        }

        // Display final score and summary
        System.out.println("Quiz Complete!");
        System.out.println("Your Final Score: " + score + "/" + quizQuestions.size());

        scanner.close();
    }

    // Initialize quiz questions
    private static void initializeQuizQuestions() {
        // Sample quiz questions with options and correct answers
        List<String> options1 = Arrays.asList("A) Java", "B) Python", "C) C++", "D) JavaScript");
        quizQuestions.add(new QuizQuestion("Which programming language is used for Android development?", options1, 0));

        List<String> options2 = Arrays.asList("A) HTML", "B) CSS", "C) Java", "D) Python");
        quizQuestions.add(new QuizQuestion("Which technology is used for styling web pages?", options2, 1));

        List<String> options3 = Arrays.asList("A) CPU", "B) GPU", "C) RAM", "D) HDD");
        quizQuestions.add(new QuizQuestion("Which component is responsible for processing data in a computer?", options3, 0));
    }

    // Present a single quiz question with options and handle user input
    private static void presentQuestion(QuizQuestion question, int questionNumber) {
        System.out.println("\nQuestion " + questionNumber + ": " + question.getQuestion());
        List<String> options = question.getOptions();
        for (String option : options) {
            System.out.println(option);
        }

        System.out.print("Enter your choice (1-" + options.size() + "): ");
        int selectedOptionIndex = scanner.nextInt() - 1; // Convert to zero-based index

        // Validate user input and check answer
        if (selectedOptionIndex >= 0 && selectedOptionIndex < options.size()) {
            if (question.isCorrectAnswer(selectedOptionIndex)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }
}
