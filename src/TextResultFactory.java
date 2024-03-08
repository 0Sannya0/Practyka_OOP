
// Фабрика для створення відображувача результатів у вигляді текстової таблиці
class TextTableResultFactory implements ResultFactory {
    @Override
    public ResultDisplayer createResultDisplayer() {
        return new TextTableResultDisplayer();
    }
}
