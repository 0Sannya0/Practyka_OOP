import java.util.Scanner;

public class main {
    @SuppressWarnings("static-access")
    public static void Main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        
        System.out.println("Enter the value of alpha: ");
        double alpha = scanner.nextDouble();

        ParametersResult parametersResult = new ParametersResult();
        parametersResult.setAlpha(alpha);
        parametersResult.setMaxSequenceLength(10); // Приклад значення для максимальної довжини послідовності

        SolutionFinder solutionFinder = new SolutionFinder(parametersResult);

        int maxSequenceLength = solutionFinder.calculateMaxSequenceLength();
        System.out.println("Max sequence length: " + maxSequenceLength);

        ObjectStateDemo objectStateDemo = new ObjectStateDemo();
        objectStateDemo.main(args);

        scanner.close();
    }
}


