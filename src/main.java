import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the value of alpha: ");
        double alpha = scanner.nextDouble();

        ParametersResult parametersResult = new ParametersResult();
        parametersResult.setAlpha(alpha);
        parametersResult.setMaxSequenceLength(10);

        SolutionFinder solutionFinder = new SolutionFinder(parametersResult);
        int maxSequenceLength = solutionFinder.calculateMaxSequenceLength();

        CalculationResultCollection resultCollection = new CalculationResultCollection();
        resultCollection.addResult(maxSequenceLength);

        ResultFactory resultFactory = getResultFactory(); // Виклик методу getResultFactory()
        ResultDisplayer resultDisplayer = resultFactory.createResultDisplayer();
        resultDisplayer.displayResult(resultCollection.getResults());
        scanner.close();
    }

    // Метод для динамічного вибору фабрики результатів
    private static ResultFactory getResultFactory() {
        return new TextTableResultFactory(); 
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
// Клас для представлення результатів як текстової таблиці
class TextTableResultDisplayer extends ResultDisplayer {
    @Override
    public void displayResult(List<Integer> results) {
        System.out.println("Table display of results:");
        System.out.println("----------------------------");
        System.out.println("| Index | Max Sequence Length |");
        System.out.println("----------------------------");
        for (int i = 0; i < results.size(); i++) {
            System.out.printf("| %-5d | %-19d |\n", i, results.get(i));
        }
        System.out.println("----------------------------");
    }
}
// Фабрика для створення відображувача результатів у вигляді текстової таблиці
class TextTableResultFactory implements ResultFactory {
    @Override
    public ResultDisplayer createResultDisplayer() {
        return new TextTableResultDisplayer();
    }
}
