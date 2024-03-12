import java.util.Scanner;
import java.util.List;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// Основний клас програми
public class Main {
    private static final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static final CalculationResultCollection resultCollection = new CalculationResultCollection();
    private static final Menu menu = MenuSingleton.getInstance().getMenu();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Головний цикл вибору опцій
        while (true) {
            System.out.println("1. Calculate max sequence length");
            System.out.println("2. Display calculation history");
            System.out.println("3. Process collection in parallel");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    calculateMaxSequenceLength(scanner);
                    break;
                case 2:
                    displayHistory();
                    break;
                case 3:
                    processCollectionInParallel();
                    break;
                case 4:
                    // Вихід з програми
                    System.out.println("Exiting...");
                    shutdownExecutor();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }
    // Обчислення максимальної довжини послідовності 1
    private static void calculateMaxSequenceLength(Scanner scanner) {
        System.out.println("Enter the value of alpha: ");
        double alpha = scanner.nextDouble();

        ParametersResult parametersResult = new ParametersResult();
        parametersResult.setAlpha(alpha);
        parametersResult.setMaxSequenceLength(10);

        SolutionFinder solutionFinder = new SolutionFinder(parametersResult);
        int maxSequenceLength = solutionFinder.calculateMaxSequenceLength();

        resultCollection.addResult(maxSequenceLength);
        menu.addResult(maxSequenceLength);
    }
    // Виведення історії обчислень
    private static void displayHistory() {
        List<Integer> results = menu.getResults();
        System.out.println("Table display of results:");
        System.out.println("----------------------------");
        System.out.println("| Index | Max Sequence Length |");
        System.out.println("----------------------------");
        for (int i = 0; i < results.size(); i++) {
            System.out.printf("| %-5d | %-19d |\n", i, results.get(i));
        }
        System.out.println("----------------------------");
    }

    private static void processCollectionInParallel() {
        System.out.println("Processing collection in parallel...");
        for (int element : resultCollection.getResults()) {
            executor.execute(() -> {
                menu.addResult(element);
            });
        }
    }

    private static void shutdownExecutor() {
        executor.shutdown();
    }
}
