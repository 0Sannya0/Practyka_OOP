import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class main {
    public static void Main(String[] args) {
            Scanner scanner = new Scanner(System.in);// Створення об'єкта Scanner для отримання вводу від користувача
        System.out.println("Enter the value of alpha: ");
        
        double alpha = scanner.nextDouble(); // Отримання введеного користувачем значення alpha

        ParametersResult parametersResult = new ParametersResult();
        parametersResult.setAlpha(alpha);
        parametersResult.setMaxSequenceLength(10);

        SolutionFinder solutionFinder = new SolutionFinder(parametersResult); // Створення об'єкта solutionFinder та передача йому parametersResult
        int maxSequenceLength = solutionFinder.calculateMaxSequenceLength();  // Обчислення максимальної довжини послідовності

        // Створення об'єкта resultCollection та додавання результату обчислення
        CalculationResultCollection resultCollection = new CalculationResultCollection();
        resultCollection.addResult(maxSequenceLength);

        // Створення об'єкта resultFactory для відображення результатів
        ResultFactory resultFactory = new TextResultFactory();
        // Створення об'єкта resultDisplayer для відображення результатів
        ResultDisplayer resultDisplayer = resultFactory.createResultDisplayer();
        // Відображення результатів
        resultDisplayer.displayResult(resultCollection.getResults());

        scanner.close();
    }
}
// Клас для зберігання результатів обчислень
class CalculationResultCollection {
    private List<Integer> results;
    // Конструктор класу
    public CalculationResultCollection() {
        results = new ArrayList<>();
    }
    // Метод для додавання результату обчислення
    public void addResult(int result) {
        results.add(result);
    }
    // Метод для отримання результатів
    public List<Integer> getResults() {
        return results;
    }
}
