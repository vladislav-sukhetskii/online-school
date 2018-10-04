package net.thumbtack.school.windows.v1;

import java.util.Objects;

public class Point {

    private int xPoint;
    private int yPoint;

    public Point(int x, int y) {
        xPoint = x;
        yPoint = y;
    }

    public Point() {
        xPoint = 0;
        yPoint = 0;
    }

    public Point(Point point) {
        this.yPoint = point.yPoint;
        this.xPoint = point.yPoint;
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
        int desktopX = desktop.getWidth();
        int desktopY = desktop.getHeight();
        return xPoint < desktopX && xPoint >= 0 && yPoint >= 0 && yPoint < desktopY;
    }

    public boolean isNotVisibleOnDesktop(Desktop desktop) {
        int desktopX = desktop.getWidth();
        int desktopY = desktop.getHeight();
        return xPoint >= desktopX || xPoint < 0 || yPoint < 0 || yPoint >= desktopY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        net.thumbtack.school.windows.v1.Point point = (net.thumbtack.school.windows.v1.Point) o;
        return xPoint == point.xPoint &&
                yPoint == point.yPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPoint, yPoint);
    }
}

