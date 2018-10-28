package net.thumbtack.school.windows.v4;

import java.util.Objects;

public class Point {

    private int xPoint,yPoint;

    public Point(int x, int y) {
        xPoint = x;
        yPoint = y;
    }

    public Point() {
        this(0,0);
    }

    public Point(Point point) {
        this(point.getX(),point.getY());
    }

    public int getX() {
        return xPoint;
    }

    public int getY() {
        return yPoint;
    }

    public void setX(int x) {
        xPoint = x;
    }

    public void setY(int y) {
        yPoint = y;
    }

    public void moveTo(int x, int y) {
        xPoint = x;
        yPoint = y;
    }

    public void moveRel(int dx, int dy) {
        xPoint += dx;
        yPoint += dy;
    }

    public boolean isVisibleOnDesktop(Desktop desktop) {
        return xPoint < desktop.getWidth() && xPoint >= 0 && yPoint >= 0 && yPoint < desktop.getHeight();
    }

    public boolean isNotVisibleOnDesktop(Desktop desktop) {
        return xPoint >= desktop.getWidth() || xPoint < 0 || yPoint < 0 || yPoint >= desktop.getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return xPoint == point.xPoint &&
                yPoint == point.yPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPoint, yPoint);
    }
}

