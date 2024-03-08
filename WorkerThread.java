
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkerThread {
    private final BlockingQueue<Command> queue;

    public WorkerThread() {
        this.queue = new LinkedBlockingQueue<>();
        Thread worker = new Thread(() -> {
            while (true) {
                try {
                    Command command = queue.take();
                    int element = command.getElement();
                    command.execute(element); // Викликаємо метод без аргументів
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        worker.start();
    }

    public void addCommand(Command command) {
        queue.offer(command);
    }
}
