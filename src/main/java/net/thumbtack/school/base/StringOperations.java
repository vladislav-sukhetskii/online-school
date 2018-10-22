package net.thumbtack.school.base;

import java.text.DecimalFormat;
import java.util.StringJoiner;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int sumLength = 0;
        for (String element : strings) {
            sumLength += element.length();
        }
        return sumLength;
    }

    public static String getFirstAndLastLetterString(String string) {
        return string.substring(0, 1).concat(string.substring(string.length() - 1));
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        boolean result = false;
        if (string1.compareTo(string2) < 0) {
            result = true;
        }
        return result;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        boolean result = false;
        if (string1.compareToIgnoreCase(string2) < 0) {
            result = true;
        }
        return result;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        int j = 0;
        String result;
        int lenght = (string1.length() < string2.length()) ? string1.length() : string2.length();
        for (int i = 0; i < lenght; i++) {
            if (StringOperations.isSameCharAtPosition(string1, string2, i)) {
                j++;
            } else break;
        }
        result = (j > 0) ? string1.substring(0, j) : "";
        return result;
    }

    public static String reverse(String string) {
        return new StringBuffer(string).reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        return (string.compareTo(StringOperations.reverse(string)) == 0);
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return (string.compareToIgnoreCase(StringOperations.reverse(string)) == 0);
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        int strLength = 0;
        String result = "";
        for (String element : strings) {
            if (StringOperations.isPalindromeIgnoreCase(element) && element.length() > strLength) {
                strLength = element.length();
                result = element;
            }
        }
        return result;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        return string1.regionMatches(index, string2, index, length);
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        return (string1.replace(replaceInStr1, replaceByInStr1).compareTo(string2.replace(replaceInStr2, replaceByInStr2)) == 0);
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        return (string1.replaceAll(replaceInStr1, replaceByInStr1).compareTo(string2.replaceAll(replaceInStr2, replaceByInStr2)) == 0);
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        return StringOperations.isPalindromeIgnoreCase(string.trim().replace(" ", ""));
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return (string1.trim().compareTo(string2.trim()) == 0);
    }

    public static String makeCsvStringFromInts(int[] array) {
        StringJoiner sj = new StringJoiner(",");
        String result = "";
        if (array.length > 0) {
            for (int element : array) {
                sj.add(Integer.toString(element));
            }
            result = sj.toString();
        }
        return result;
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        String result = "";
        StringJoiner sj = new StringJoiner(",");
        DecimalFormat fmt = new DecimalFormat("000.00");
        if (array.length > 0) {
            for (double element : array) {
                sj.add(fmt.format(element));
            }
            result = sj.toString();
        }
        return result;
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        return new StringBuilder().append(makeCsvStringFromInts(array));
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        return new StringBuilder().append(makeCsvStringFromDoubles(array));
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append(string);
        for (int element : positions) {
            sb.deleteCharAt(element - i);
            i++;
        }
        return sb;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        sb.append(string);
        for (int i = 0; i < positions.length; i++) {
            sb.insert(positions[i] + j, characters[i]);
            j++;

        }
        return sb;
    }


}
