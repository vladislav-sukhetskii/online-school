package net.thumbtack.school.windows.v4.base;

public enum WindowState {
    ACTIVE, INACTIVE, DESTROYED;

    public static WindowState fromString(String stateString) throws WindowException {
            return WindowState.valueOf(stateString);
    }
}
