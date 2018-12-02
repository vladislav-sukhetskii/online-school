package net.thumbtack.school.windows.v4.base;

public enum WindowErrorCode {
    WRONG_STATE("Error in window state"),
    WRONG_INDEX("Error in array`s index"),
    EMPTY_ARRAY("String array is undefined"),
    NULL_WINDOW("Window is null");

    String errorString;

    WindowErrorCode(String errorString){
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
