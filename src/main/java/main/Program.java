package main;

import functions.MeanSquaredError;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Program
{
    private static final double LEARNING_RATE = 0.1d;
    private static final double EPSILON = 0.001d;

    private double parameter = 0d;

    public static void main(final String[] args)
    {
        new Program();
    }

    private Program()
    {
        final List<Double> actual = Arrays.asList(1d, 2d, 3d);
        runGradientDescent(actual);
        System.out.println(parameter);
    }

    private List<Double> hypothesis(final List<Double> actual)
    {
        return actual.stream()
            .map(v -> v * parameter)
            .collect(Collectors.toList());
    }

    private void runGradientDescent(final List<Double> actual)
    {
        double error;
        do
        {
            final List<Double> predicted = hypothesis(actual);
            error = MeanSquaredError.calculate(predicted, actual);
            final double derivative = MeanSquaredError.calculateWithDerivative(LEARNING_RATE, predicted, actual);
            parameter -= derivative;
            System.out.printf("Error: %f Param: %f\n", error, parameter);
        }
        while(error > EPSILON);
    }
}
