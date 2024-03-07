import java.util.List;
import java.util.ArrayList;

class CalculationResultCollection {
    private List<Integer> results;

    public CalculationResultCollection() {
        results = new ArrayList<>();
    }

    public void addResult(int result) {
        results.add(result);
    }

    public List<Integer> getResults() {
        return results;
    }
}
