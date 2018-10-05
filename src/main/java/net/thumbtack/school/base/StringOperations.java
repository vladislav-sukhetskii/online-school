package net.thumbtack.school.base;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int sumLength = 0;
        for (String element : strings) {
            sumLength += element.length();
        }
        return sumLength;
    }

    public static String getFirstAndLastLetterString(String string){
        char first,last;
        String firstAndLast;
        first = string.charAt(0);
        last = string.charAt(string.length()-1);
        char[] newStr = new char[] {first,last};
        firstAndLast = new String(newStr);
        return firstAndLast;
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index){
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character){
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character){
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }


}
