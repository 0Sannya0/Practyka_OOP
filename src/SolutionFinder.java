
class SolutionFinder {
    private ParametersResult parametersResult;

    public SolutionFinder(ParametersResult parametersResult) {
        this.parametersResult = parametersResult;
    }

    public int calculateMaxSequenceLength() {
        double alpha = parametersResult.getAlpha();
   
        double value = 10 * Math.cos(alpha);
        double square = Math.pow(value, 2);
        double cube = Math.pow(value, 3);
        double sum = square + cube;
        String binaryString = Integer.toBinaryString((int) sum);

        int count = 0;
        int maxCount = 0;
        for (char c : binaryString.toCharArray()) {
            if (c == '1') {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }

        return maxCount;
    }
}
