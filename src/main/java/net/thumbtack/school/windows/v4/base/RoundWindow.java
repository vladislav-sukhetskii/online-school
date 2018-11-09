package net.thumbtack.school.windows.v4.base;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.Point;

import java.util.Objects;

abstract public class RoundWindow extends Window {

    private Point center;
    private int radius;

    public RoundWindow(Point center, int radius, WindowState windowState) throws WindowException {
        super(windowState);
        this.center = center;
        this.radius = radius;
    }

    public RoundWindow(Point center, int radius, String windowState) throws WindowException {
        super(windowState);
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public void setCenter(int x, int y) {
        this.center = new Point(x, y);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        boolean result = true;
        Point[] dots = new Point[4];
        dots[0] = new Point((center.getX() - radius), center.getY());
        dots[1] = new Point(center.getX(), (center.getY() + radius));
        dots[2] = new Point((center.getX() + radius), center.getY());
        dots[3] = new Point(center.getX(), (center.getY() - radius));
        for (Point element : dots) {
            if (!element.isVisibleOnDesktop(desktop)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isInside(int x, int y) {
        return getRadius() >= Math.sqrt((Math.pow((Math.abs(center.getX() - x)), 2)) + Math.pow((Math.abs(center.getY() - y)), 2));
    }

    public boolean isInside(Point point) {
        return getRadius() >= Math.sqrt((Math.pow((Math.abs(center.getX() - point.getX())), 2)) + Math.pow((Math.abs(center.getY() - point.getY())), 2));
    }

    public void moveTo(int x, int y) {
        center.setX(x);
        center.setY(y);
    }

    public void moveRel(int dx, int dy) {
        this.moveTo(center.getX() + dx, center.getY() + dy);
    }

    public void resize(double ratio) {
        setRadius(((radius * ratio) < 1) ? 1 : (int) (radius * ratio));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoundWindow that = (RoundWindow) o;
        return radius == that.radius &&
                Objects.equals(center, that.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), center, radius);
    }
}
