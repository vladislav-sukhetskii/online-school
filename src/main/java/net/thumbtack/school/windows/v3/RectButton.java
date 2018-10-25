package net.thumbtack.school.windows.v3;

import net.thumbtack.school.windows.v3.base.RectWindow;

import java.util.Objects;

public class RectButton extends RectWindow {

    private String buttonText;

    public RectButton(Point topLeft, Point bottomRight, boolean active, String text) {
        super(topLeft,bottomRight,active);
        buttonText = text;
    }

    public RectButton(int xLeft, int yTop, int width, int height, boolean active, String text) {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), active, text);
    }

    public RectButton(Point topLeft, Point bottomRight, String text) {
        this(topLeft, bottomRight, true, text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, String text) {
        this(xLeft, yTop, width, height, true, text);
    }

    public void moveTo(int x, int y) {
        getBottomRight().setX(getBottomRight().getX() + x - getTopLeft().getX());
        getBottomRight().setY(getBottomRight().getY() + y - getTopLeft().getY());
        getTopLeft().setX(x);
        getTopLeft().setY(y);
    }

    public void moveRel(int dx, int dy) {
        this.moveTo(getTopLeft().getX() + dx, getTopLeft().getY() + dy);
    }

    public void resize(double ratio) {
        getBottomRight().setX(getTopLeft().getX() + (((getWidth() * ratio) < 1) ? 1 : (int) (getWidth() * ratio)) - 1);
        getBottomRight().setY(getTopLeft().getY() + (((getHeight() * ratio) < 1) ? 1 : (int) (getHeight() * ratio)) - 1);
    }

    public boolean isIntersects(RectButton rectButton) {
        boolean result = false;
        if (!(rectButton.getTopLeft().getY() > getBottomRight().getY() || rectButton.getTopLeft().getX() > getBottomRight().getX() || rectButton.getBottomRight().getY() < getTopLeft().getY() || rectButton.getBottomRight().getX() < getTopLeft().getX())) {
            result = true;
        }
        return result;
    }

    public boolean isInside(RectButton rectButton) {
        return isInside(rectButton.getTopLeft()) && isInside(rectButton.getBottomRight());
    }

    public String getText() {
        return buttonText;
    }

    public void setText(String text) {
        buttonText = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RectButton that = (RectButton) o;
        return Objects.equals(buttonText, that.buttonText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), buttonText);
    }
}
