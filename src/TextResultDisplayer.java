import java.util.List;

class TextResultDisplayer extends ResultDisplayer {
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
