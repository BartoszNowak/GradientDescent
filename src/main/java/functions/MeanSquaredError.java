package functions;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MeanSquaredError
{
    public Double calculate(final Double predicted, final Double actual)
    {
        return Math.pow(predicted - actual, 2);
    }

    public Double calculate(final List<Double> predicted, final List<Double> actual)
    {
        Double sum = 0d;
        for(int i = 0; i < predicted.size(); i++)
        {
            sum += calculate(predicted.get(i), actual.get(i));
        }
        return sum / (predicted.size() * 2);
    }

    public Double calculateWithDerivative(final Double learningRate, final List<Double> predicted, final List<Double> actual)
    {
        Double sum = 0d;
        for(int i = 0; i < predicted.size(); i++)
        {
            sum += predicted.get(i) - actual.get(i);
        }
        return learningRate * sum / predicted.size();
    }
}
