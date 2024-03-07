import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> results = new ArrayList<>();
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
                    results.add(maxSequenceLength);
                    System.out.println("Max sequence length: " + maxSequenceLength);
                    break;
                case 2:
                    System.out.println("Calculation history:");
                    for (int i = 0; i < results.size(); i++) {
                        System.out.println("Calculation " + (i + 1) + ": " + results.get(i));
                    }
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
}
