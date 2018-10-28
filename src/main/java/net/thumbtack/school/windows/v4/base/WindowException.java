package net.thumbtack.school.windows.v4.base;

public class WindowException extends Exception {

    WindowErrorCode windowErrorCode;

    public WindowException(WindowErrorCode windowErrorCode){
        super(windowErrorCode.getErrorString());

    };

    public WindowErrorCode getWindowErrorCode() {
        return windowErrorCode;
    }
}
