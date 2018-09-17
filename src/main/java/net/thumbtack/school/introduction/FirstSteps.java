package net.thumbtack.school.introduction;

public class FirstSteps {

    public int sum(int x, int y) {
        int result;
        result = x + y;
        return result;
    }


    public int mul(int x, int y) {
        int result;
        result = x * y;
        return result;
    }


    public int div(int x, int y) {
        int result;
        result = x / y;
        return result;
    }


    public int mod(int x, int y) {
        int result;
        result = x % y;
        return result;
    }


    public boolean isEqual(int x, int y) {
        boolean result;
        result = x == y;
        return result;
    }


    public boolean isGreater(int x, int y) {
        boolean result;
        result = x > y;
        return result;
    }


    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        boolean result;
        result = ((x >= xLeft) && (x <= xRight)) && ((y >= yTop) && (y <= yBottom));
        return result;
    }


    public int sum(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
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
        int indexMin = 0, result;
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
        int indexMax = 0, result;
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

    public double average(int[] array) {
        double arraySum = 0, result;
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                arraySum += (double) array[i];
            }
            result = arraySum / (double) (array.length);
        } else result = 0;
        return result;
    }

    public boolean isSortedDescendant(int[] array) {
        boolean result = true;
        for (int i = 0; i < (array.length - 1); i++) {
            if (array[i] <= array[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void cube(int[] array) {
        int exp = 3;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.pow(array[i], exp);
        }
    }

    public boolean find(int[] array, int value) {
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) result = true;
        }
        return result;
    }

    public void reverse(int[] array) {
        int temp = 0, lastPos = array.length - 1;
        for (int i = 0; i < (array.length / 2); i++) {
            temp = array[i];
            array[i] = array[lastPos - i];
            array[lastPos - i] = temp;
        }
    }

    public boolean isPalindrome(int[] array) {
        boolean result = true;
        for (int i = 0; i < (array.length / 2); i++) {
            if (array[i] != array[array.length - 1 - i]) {
                result = false;
            }
        }
        return result;
    }

    public int sum(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < (matrix.length); i++) {
            for (int j = 0; j < (matrix[i].length); j++) {
                result += matrix[i][j];
            }
        }
        return result;
    }

    public int max(int[][] matrix) {
        int result = 0;
        if (matrix.length > 1) {
            for (int i = 0; i < (matrix.length); i++) {
                for (int j = 0; j < (matrix[i].length); j++) {
                    if (result < matrix[i][j]) {
                        result = matrix[i][j];
                    }
                }
            }
        } else result = Integer.MIN_VALUE;
        return result;
    }

    public int diagonalMax(int[][] matrix) {
        int result = 0;
        if (matrix.length > 1) {
            for (int i = 0; i < (matrix.length); i++) {
                for (int j = 0; j < (matrix[i].length); j++) {
                    if (i == j) {
                        result = matrix[i][j];
                    }
                }
            }
        } else result = Integer.MIN_VALUE;
        return result;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        boolean result = true;
        for (int i = 0; i < (matrix.length); i++) {
            if (isSortedDescendant(matrix[i]) == false) {
                result = false;
                break;
            }
        }
        return result;
    }


}

