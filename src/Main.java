import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        CalculationResultCollection resultCollection = new CalculationResultCollection();
        while (true) {
            System.out.println("1. Calculate max sequence length");
            System.out.println("2. Display calculation history");
            System.out.println("3. Exit");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                                        System.out.println("Enter the value of alpha: ");
                    double alpha = scanner.nextDouble();

                    ParametersResult parametersResult = new ParametersResult();
                    parametersResult.setAlpha(alpha);
                    parametersResult.setMaxSequenceLength(10);

                    SolutionFinder solutionFinder = new SolutionFinder(parametersResult);
                    int maxSequenceLength = solutionFinder.calculateMaxSequenceLength();

                    resultCollection.addResult(maxSequenceLength);
                    break;
                case 2:
                displayHistory(resultCollection);
                break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }


private static void displayHistory(CalculationResultCollection resultCollection) {
    List<Integer> results = resultCollection.getResults();
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