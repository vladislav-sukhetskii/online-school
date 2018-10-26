package net.thumbtack.school.windows.v3.base;

import net.thumbtack.school.windows.v3.Desktop;
import net.thumbtack.school.windows.v3.Point;

import java.util.Objects;

abstract public class RectWindow extends Window {

    private Point topLeft, bottomRight;

    public RectWindow(Point topLeft, Point bottomRight, boolean active) {
        super(active);
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getWidth() {
        return bottomRight.getX() - topLeft.getX() + 1;
    }

    public int getHeight() {
        return bottomRight.getY() - topLeft.getY() + 1;
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return getTopLeft().isVisibleOnDesktop(desktop) && getBottomRight().isVisibleOnDesktop(desktop);
    }

    public boolean isInside(int x, int y) {
        return x >= getTopLeft().getX() && x <= getBottomRight().getX() && y >= getTopLeft().getY() && y <= getBottomRight().getY();
    }

    public boolean isInside(Point point) {
        return this.isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RectWindow that = (RectWindow) o;
        return Objects.equals(topLeft, that.topLeft) &&
                Objects.equals(bottomRight, that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), topLeft, bottomRight);
    }
}
