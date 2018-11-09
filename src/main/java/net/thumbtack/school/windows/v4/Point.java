package net.thumbtack.school.windows.v4;

import java.io.Serializable;
import java.util.Objects;

public class Point  {

    private int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0,0);
    }

    public Point(Point point) {
        this(point.getX(),point.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveRel(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public boolean isVisibleOnDesktop(Desktop desktop) {
        return x < desktop.getWidth() && x >= 0 && y >= 0 && y < desktop.getHeight();
    }

    public boolean isNotVisibleOnDesktop(Desktop desktop) {
        return x >= desktop.getWidth() || x < 0 || y < 0 || y >= desktop.getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

