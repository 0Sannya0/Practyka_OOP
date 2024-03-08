import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Collection;

public class ParallelProcessor {
    private final ExecutorService executor;

    public ParallelProcessor() {
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void process(Collection<Integer> collection, Command command) {
        for (int element : collection) {
            executor.execute(() -> {
                command.execute(element);
            });
        }
    }
    public void shutdown() {
        executor.shutdown();
    }
}