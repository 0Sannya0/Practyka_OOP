import java.util.List;

public class Test {
    public static void main(String[] args) {
    }
}

abstract class ResultDisplayer {
    public abstract void displayResult(List<Integer> results);
}

class TextResultDisplayer extends ResultDisplayer {
    @Override
    public void displayResult(List<Integer> results) {
        for (int result : results) {
            System.out.println("Max sequence length: " + result);
        }
    }
}

interface ResultFactory {
    ResultDisplayer createResultDisplayer();
}

class TextResultFactory implements ResultFactory {
    @Override
    public ResultDisplayer createResultDisplayer() {
        return new TextResultDisplayer();
    }
}

