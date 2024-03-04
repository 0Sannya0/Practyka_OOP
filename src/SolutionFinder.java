public class SolutionFinder {
    private ParametersResult parametersResult;
    @SuppressWarnings("unused")
    private int maxSequenceLength; // змінна для зберігання максимальної довжини послідовності
    public SolutionFinder(ParametersResult parametersResult) {
        this.parametersResult = parametersResult;
        this.maxSequenceLength = 0; // початкове значення максимальної довжини
    }
    public int calculateMaxSequenceLength() {
        double alpha = parametersResult.getAlpha();
        int maxSequenceLength = parametersResult.getMaxSequenceLength();   
        double value = 10 * Math.cos(alpha); // Обчислення значення 10*cos(α)
        double square = Math.pow(value, 2);  // Обчислення квадрата
        double cube = Math.pow(value, 3); // Обчислення куба
        double sum = square + cube;    // Сума квадрата і куба
        String binaryString = Integer.toBinaryString((int) sum);   // Перетворення суми в двійкове представлення
        // Знаходження найбільшої послідовності одиниць
        int count = 0;
        for (char c : binaryString.toCharArray()) {
            if (c == '1') {
                count++;
                if (count > maxSequenceLength) {
                    maxSequenceLength = count;
                }
            } else {
                count = 0;
            }
        }
        return maxSequenceLength; // Повертаємо максимальну довжину послідовності одиниць
    }
}
