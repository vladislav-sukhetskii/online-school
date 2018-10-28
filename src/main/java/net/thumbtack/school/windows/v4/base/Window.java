package net.thumbtack.school.windows.v4.base;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.iface.Movable;
import net.thumbtack.school.windows.v4.iface.Resizable;

abstract public class Window implements Movable, Resizable {

    private WindowState windowState;

    public Window(WindowState windowState) throws WindowException {
        super();
        setState(windowState);
    }

    public Window(String windowState) throws WindowException {
        super();
        setState(windowState);
    }

    public void setState(WindowState windowState) throws WindowException {
        checkState(windowState);
        this.windowState = windowState;
    }

    public void setState(String windowState) throws WindowException {
        checkState(windowState);
        this.windowState = WindowState.fromString(windowState);
    }

    private void checkState(WindowState windowState) throws WindowException {
        if (windowState == null || this.windowState == WindowState.DESTROYED)
            throw new WindowException(WindowErrorCode.WRONG_STATE);
    }

    private void checkState(String windowState) throws WindowException {
        if (windowState == null || this.windowState == WindowState.DESTROYED)
            throw new WindowException(WindowErrorCode.WRONG_STATE);
    }


    public WindowState getState() {
        return windowState;
    }

    abstract public boolean isInside(int x, int y);

    abstract public boolean isInside(Point point);

    abstract public boolean isFullyVisibleOnDesktop(Desktop desktop);

}
