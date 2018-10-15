package net.thumbtack.school.windows.v2;

import java.util.Objects;

public class RectButton3D extends RectButton {

    private int zHeight;

    public RectButton3D(Point topLeft, Point bottomRight, boolean active, String text, int zHeight) {
        super(topLeft, bottomRight, active, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, boolean active, String text, int zHeight) {
        super(xLeft, yTop, width, height, active, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(Point topLeft, Point bottomRight, String text, int zHeight) {
        super(topLeft, bottomRight, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String text, int zHeight) {
        super(xLeft, yTop, width, height, text);
        this.zHeight = zHeight;
    }

    public int getZHeight() {
        return zHeight;
    }

    public void setZHeight(int zHeight) {
        this.zHeight = zHeight;
    }

    public boolean isInside(RectButton3D rectButton3D) {
        RectButton button1 = this;
        RectButton button2 = rectButton3D;
        return (button1.isInside(button2) && this.zHeight >= rectButton3D.zHeight);
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
