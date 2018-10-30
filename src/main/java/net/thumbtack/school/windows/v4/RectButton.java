package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.RectWindow;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

import java.util.Objects;

public class RectButton extends RectWindow {

    private String buttonText;

    public RectButton(Point topLeft, Point bottomRight, WindowState windowState, String text) throws WindowException {
        super(topLeft, bottomRight, windowState);
        buttonText = text;
    }

    public RectButton(Point topLeft, Point bottomRight, String windowState, String text) throws WindowException {
        super(topLeft, bottomRight, windowState);
        buttonText = text;
    }

    public RectButton(int xLeft, int yTop, int width, int height, WindowState windowState, String text) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), windowState, text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, String windowState, String text) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), windowState, text);
    }

    public RectButton(Point topLeft, Point bottomRight, String text) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE, text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, String text) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.ACTIVE, text);
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
