package net.thumbtack.school.windows.v4.managers;

import net.thumbtack.school.windows.v4.cursors.Cursor;
import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.base.Window;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;

public class ArrayManager<T extends Window> {

    private T[] windows;

    public ArrayManager(T[] windows) throws WindowException {
        super();
        for (T element : windows) {
            if (element == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        }
        this.windows = windows;
    }

    public T[] getWindows() {
        return windows;
    }

    public void setWindows(T[] windows) {
        this.windows = windows;
    }

    public void setWindow(T window, int i) throws WindowException {
        if (i < 0 || i > windows.length - 1) throw new WindowException(WindowErrorCode.WRONG_INDEX);
        if (window == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        windows[i] = window;
    }

    public T getWindow(int i) throws WindowException {
        if (i < 0 || i > windows.length - 1) throw new WindowException(WindowErrorCode.WRONG_INDEX);
        return windows[i];
    }

    public boolean isSameSize(ArrayManager arrayManager) {
        return (this.windows.length - arrayManager.getWindows().length) == 0;
    }

    public boolean allWindowsFullyVisibleOnDesktop(Desktop desktop) {
        boolean result = true;
        for (T element : windows) {
            if (!element.isFullyVisibleOnDesktop(desktop)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean anyWindowFullyVisibleOnDesktop(Desktop desktop) {
        boolean result = false;
        for (T element : windows) {
            if (element.isFullyVisibleOnDesktop(desktop)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public Window getFirstWindowFromCursor(Cursor cursor) {
        T result = null;
        for (T element : windows) {
            if (element.isInside(cursor.getX(), cursor.getY())) {
                result = element;
                break;
            }
        }
        return result;
    }


}
