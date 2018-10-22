package net.thumbtack.school.introduction;

public class FirstSteps {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return ((x >= xLeft) && (x <= xRight)) && ((y >= yTop) && (y <= yBottom));
    }

    public int sum(int[] array) {
        int result = 0;
        for (int element : array) {
            result += element;
        }
        return result;
    }

    public int mul(int[] array) {
        int result = 0;
        if (array.length > 0) {
            result = 1;
            for (int element : array) {
                result *= element;
            }
        }
        return result;
    }

    public int min(int[] array) {
        int result = Integer.MAX_VALUE;
        if (array.length > 0) {
            for (int element : array) {
                if (element < result) {
                    result = element;
                }
            }
        }
        return result;
    }

    public int max(int[] array) {
        int result = Integer.MIN_VALUE;
        if (array.length > 0) {
            for (int element : array) {
                if (element > result) {
                    result = element;
                }
            }
        }
        return result;
    }

    public double average(int[] array) {
        double result = 0;
        if (array.length > 0) {
            for (int element : array) {
                result += (double) element;
            }
            result = result / (double) (array.length);
        }
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
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.pow(array[i], 3);
        }
    }

    public boolean find(int[] array, int value) {
        boolean result = false;
        for (int element : array) {
            if (element == value) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void reverse(int[] array) {
        for (int i = 0; i < (array.length / 2); i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public boolean isPalindrome(int[] array) {
        boolean result = true;
        for (int i = 0; i < (array.length / 2); i++) {
            if (array[i] != array[array.length - 1 - i]) {
                result = false;
                break;
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
        int result = Integer.MIN_VALUE;
        if (matrix.length > 1) {
            for (int i = 0; i < (matrix.length); i++) {
                for (int j = 0; j < (matrix[i].length); j++) {
                    if (matrix[i][j] > result) {
                        result = matrix[i][j];
                    }
                }
            }
        }
        return result;
    }

    public int diagonalMax(int[][] matrix) {
        int result = Integer.MIN_VALUE;
        if (matrix.length > 0) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][i] > result) {
                    result = matrix[i][i];
                }
            }
        }
        return result;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        boolean result = true;
        for (int i = 0; i < (matrix.length); i++) {
            if (!isSortedDescendant(matrix[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}

