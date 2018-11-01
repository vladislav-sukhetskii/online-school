package net.thumbtack.school.windows.v4.base;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.iface.Movable;
import net.thumbtack.school.windows.v4.iface.Resizable;

import java.util.Objects;

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
        if (windowState == null || (this.windowState == null && windowState == WindowState.DESTROYED) || this.windowState == WindowState.DESTROYED)
            throw new WindowException(WindowErrorCode.WRONG_STATE);
    }

    private void checkState(String windowState) throws WindowException {
        if (windowState == null || (this.windowState == null && windowState.equals("DESTROYED")) || this.windowState == WindowState.DESTROYED)
            throw new WindowException(WindowErrorCode.WRONG_STATE);
    }

    public WindowState getState() {
        return windowState;
    }

    abstract public boolean isInside(int x, int y);

    abstract public boolean isInside(Point point);

    abstract public boolean isFullyVisibleOnDesktop(Desktop desktop);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Window window = (Window) o;
        return windowState == window.windowState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(windowState);
    }
}
