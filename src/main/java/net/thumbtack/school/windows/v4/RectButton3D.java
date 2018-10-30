package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

import java.util.Objects;

public class RectButton3D extends RectButton {

    private int zHeight;

    public RectButton3D(Point topLeft, Point bottomRight, WindowState windowState, String text, int zHeight) throws WindowException {
        super(topLeft, bottomRight, windowState, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(Point topLeft, Point bottomRight, String windowState, String text, int zHeight) throws WindowException {
        super(topLeft, bottomRight, windowState, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, WindowState windowState, String text, int zHeight) throws WindowException {
        super(xLeft, yTop, width, height, windowState, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String windowState, String text, int zHeight) throws WindowException {
        super(xLeft, yTop, width, height, windowState, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(Point topLeft, Point bottomRight, String text, int zHeight) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE, text, zHeight);
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String text, int zHeight) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.ACTIVE, text, zHeight);
    }

    public int getZHeight() {
        return zHeight;
    }

    public void setZHeight(int zHeight) {
        this.zHeight = zHeight;
    }

    public boolean isInside(RectButton3D rectButton3D) {
        return (this.isInside((RectButton) rectButton3D) && this.zHeight >= rectButton3D.zHeight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RectButton3D that = (RectButton3D) o;
        return zHeight == that.zHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), zHeight);
    }
}
