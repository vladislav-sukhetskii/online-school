package net.thumbtack.school.windows.v4.base;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.RectButton;

import java.util.Objects;

abstract public class RectWindow extends Window {

    private Point topLeft, bottomRight;

    public RectWindow(Point topLeft, Point bottomRight, WindowState windowState) throws WindowException {
        super(windowState);
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public RectWindow(Point topLeft, Point bottomRight, String windowState) throws WindowException {
        super(windowState);
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
        return topLeft.isVisibleOnDesktop(desktop) && bottomRight.isVisibleOnDesktop(desktop);
    }

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= bottomRight.getX() && y >= topLeft.getY() && y <= bottomRight.getY();
    }

    public boolean isInside(Point point) {
        return this.isInside(point.getX(), point.getY());
    }

    public void moveTo(int x, int y) {
        bottomRight.setX(bottomRight.getX() + x - topLeft.getX());
        bottomRight.setY(bottomRight.getY() + y - topLeft.getY());
        topLeft.setX(x);
        topLeft.setY(y);
    }

    public void moveRel(int dx, int dy) {
        this.moveTo(topLeft.getX() + dx, topLeft.getY() + dy);
    }

    public void resize(double ratio) {
        bottomRight.setX(topLeft.getX() + (((getWidth() * ratio) < 1) ? 1 : (int) (getWidth() * ratio)) - 1);
        bottomRight.setY(topLeft.getY() + (((getHeight() * ratio) < 1) ? 1 : (int) (getHeight() * ratio)) - 1);
    }

    public boolean isInside(RectWindow rectWindow) {
        return isInside(rectWindow.topLeft) && isInside(rectWindow.getBottomRight());
    }

    public boolean isIntersects(RectWindow rectWindow) {
        boolean result = false;
        if (!(rectWindow.getTopLeft().getY() > bottomRight.getY() || rectWindow.getTopLeft().getX() > bottomRight.getX() || rectWindow.getBottomRight().getY() < topLeft.getY() || rectWindow.getBottomRight().getX() < topLeft.getX())) {
            result = true;
        }
        return result;
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
