package net.thumbtack.school.windows.v3.base;

import net.thumbtack.school.windows.v3.Desktop;
import net.thumbtack.school.windows.v3.Point;
import net.thumbtack.school.windows.v3.iface.Movable;
import net.thumbtack.school.windows.v3.iface.Resizable;

import java.util.Objects;

abstract public class Window implements Movable, Resizable {

    private boolean active;

    public Window(boolean active) {
        this.active = active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    abstract public boolean isInside(int x, int y);

    abstract public boolean isInside(Point point);

    abstract public boolean isFullyVisibleOnDesktop(Desktop desktop);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Window window = (Window) o;
        return active == window.active;
    }

    @Override
    public int hashCode() {
        return Objects.hash(active);
    }
}
