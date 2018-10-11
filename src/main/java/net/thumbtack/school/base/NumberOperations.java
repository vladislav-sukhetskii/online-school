package net.thumbtack.school.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class NumberOperations {
    public static Integer find(int[] array, int value) {
        Integer result = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static Integer find(double[] array, double value, double eps) {
        Integer result = null;
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i] - value) < eps) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static Double calculateDensity(double weight, double volume, double min, double max) {
        Double result = null;
        double density = weight / volume;
        if (density > min && density < max) {
            result = density;
        }
        return result;
    }

    public static Integer find(BigInteger[] array, BigInteger value) {
        Integer result = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(value) == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        BigDecimal result = null;
        BigDecimal density = weight.divide(volume);
        if (density.compareTo(min) > 0 && density.compareTo(max) < 0) {
            result = density;
        }
        return result;

    }
}
