package net.thumbtack.school.windows.v4.base;

public enum WindowState {
    ACTIVE, INACTIVE, DESTROYED;

    public static WindowState fromString(String stateString) throws WindowException {
        checkStateString(stateString);
        return WindowState.valueOf(stateString);
    }

    private static void checkStateString(String stateString) throws WindowException {
        if (stateString == null) throw new WindowException(WindowErrorCode.WRONG_STATE);
        boolean stateStringNotMatch = true;
        for (WindowState element : WindowState.values()) {
            if (element.toString().equals(stateString)) {
                stateStringNotMatch = false;
            }
        }
        if (stateStringNotMatch)throw new WindowException(WindowErrorCode.WRONG_STATE);
    }
}

