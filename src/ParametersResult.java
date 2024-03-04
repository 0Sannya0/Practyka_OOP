import java.io.Serializable;
public class ParametersResult implements Serializable {
    private static final long serialVersionUID = 1L;
    private double alpha;
    private int maxSequenceLength;
    public double getAlpha() {
        return alpha;
    }
    public void setAlpha(double alpha) {
        this.alpha = alpha;}
    public int getMaxSequenceLength() {
        return maxSequenceLength;
    }
    public void setMaxSequenceLength(int maxSequenceLength) {
        this.maxSequenceLength = maxSequenceLength;
    }
    @Override
    public String toString() {
        return "ParametersResult{" +
                "alpha=" + alpha +
                ", maxSequenceLength=" + maxSequenceLength +
                '}';
    }
}
