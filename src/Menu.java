
import java.util.List;

class Menu {
    private List<Integer> results;

    public Menu(List<Integer> results) {
        this.results = results;
    }

    public void addResult(int result) {
        results.add(result);
    }

    public List<Integer> getResults() {
        return results;
    }
}
