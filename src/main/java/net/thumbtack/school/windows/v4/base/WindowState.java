package net.thumbtack.school.windows.v4.base;

public enum WindowState {
    ACTIVE, INACTIVE, DESTROYED;

    public static WindowState fromString(String stateString) throws WindowException {
        checkStateString(stateString);
        return WindowState.valueOf(stateString);
    }

    private static void checkStateString(String stateString) throws WindowException {
        if (stateString == null) throw new WindowException(WindowErrorCode.WRONG_STATE);
        for (WindowState element : WindowState.values()) {
            if (element != WindowState.valueOf(stateString)) {
                return;
            }
        }
        throw new WindowException(WindowErrorCode.WRONG_STATE);
    }
}

