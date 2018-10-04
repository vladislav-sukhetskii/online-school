package net.thumbtack.school.windows.v1;

import java.util.Objects;

public class Desktop {
    private int desktopWidth;
    private int desktopHeight;

    public Desktop(int width, int height) {
        desktopWidth = width;
        desktopHeight = height;
    }

    public Desktop() {
        desktopWidth = 640;
        desktopHeight = 480;
    }

    public int getWidth() {
        return desktopWidth;
    }

    public int getHeight() {
        return desktopHeight;
    }

    public int getArea() {
        return desktopHeight * desktopWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desktop desktop = (Desktop) o;
        return desktopWidth == desktop.desktopWidth &&
                desktopHeight == desktop.desktopHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(desktopWidth, desktopHeight);
    }
}

