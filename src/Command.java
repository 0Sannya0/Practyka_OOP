public interface Command {
    void execute(int element);
    void undo();
    int getElement();
}
