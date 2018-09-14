package net.thumbtack.school.introduction;

public class FirstSteps {

    public int sum(int x, int y) {
        int result = x + y;
        return result;
    }


    public int mul(int x, int y) {
        int result = x * y;
        return result;
    }


    public int div(int x, int y) {
        int result = x / y;
        return result;
    }


    public int mod(int x, int y) {
        int result = x % y;
        return result;
    }


    public boolean isEqual(int x, int y) {
        boolean result = x == y;
        return result;
    }


    public boolean isGreater(int x, int y) {
        boolean result = x > y;
        return result;
    }


    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        boolean result = ((x >= xLeft) && (x <= xRight)) && ((y >= yTop) && (y <= yBottom));
        return result;
    }


    public int sum(int[] array) {
        int result = 0;
        for (int x : array) {
            result += x;
        }
        return result;
    }


    public int mul(int[] array) {
        int result = 1;
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                result *= array[i];
            }
        } else result = 0;
        return result;
    }


    public int min(int[] array) {
        int indexMin = 0;
        int result;
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] < array[indexMin]) {
                    indexMin = i;
                }
            }
            result = array[indexMin];
        } else result = Integer.MAX_VALUE;
        return result;
    }

    public int max(int[] array) {
        int indexMax = 0;
        int result;
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] > array[indexMax]) {
                    indexMax = i;
                }
            }
            result = array[indexMax];
        } else result = Integer.MIN_VALUE;
        return result;
    }

}
