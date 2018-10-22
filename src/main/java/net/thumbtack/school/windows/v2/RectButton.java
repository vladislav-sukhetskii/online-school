package net.thumbtack.school.windows.v2;

import java.util.Objects;

public class RectButton {

    private boolean buttonActive;
    private Point buttonTopLeft, buttonBottomRight;
    private String buttonText;

    public RectButton(Point topLeft, Point bottomRight, boolean active, String text) {
        buttonTopLeft = topLeft;
        buttonBottomRight = bottomRight;
        buttonActive = active;
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

    public Point getTopLeft() {
        return buttonTopLeft;
    }

    public Point getBottomRight() {
        return buttonBottomRight;
    }

    public boolean isActive() {
        return buttonActive;
    }

    public void setTopLeft(Point topLeft) {
        buttonTopLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        buttonBottomRight = bottomRight;
    }

    public void setActive(boolean active) {
        buttonActive = active;
    }

    public int getWidth() {
        return buttonBottomRight.getX() - buttonTopLeft.getX() + 1;
    }

    public int getHeight() {
        return buttonBottomRight.getY() - buttonTopLeft.getY() + 1;
    }

    public void moveTo(int x, int y) {
        buttonBottomRight.setX(buttonBottomRight.getX() + x - buttonTopLeft.getX());
        buttonBottomRight.setY(buttonBottomRight.getY() + y - buttonTopLeft.getY());
        buttonTopLeft.setX(x);
        buttonTopLeft.setY(y);
    }

    public void moveTo(Point point) {
        this.moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        this.moveTo(buttonTopLeft.getX() + dx, buttonTopLeft.getY() + dy);
    }

    public void resize(double ratio) {
        buttonBottomRight.setX(buttonTopLeft.getX() + (((getWidth() * ratio) < 1) ? 1 : (int) (getWidth() * ratio)) - 1);
        buttonBottomRight.setY(buttonTopLeft.getY() + (((getHeight() * ratio) < 1) ? 1 : (int) (getHeight() * ratio)) - 1);
    }

    public boolean isInside(int x, int y) {
        return x >= buttonTopLeft.getX() && x <= buttonBottomRight.getX() && y >= buttonTopLeft.getY() && y <= buttonBottomRight.getY();
    }

    public boolean isInside(Point point) {
        return this.isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(RectButton rectButton) {
        boolean result = false;
        if (!(rectButton.getTopLeft().getY() > buttonBottomRight.getY() || rectButton.getTopLeft().getX() > buttonBottomRight.getX() || rectButton.getBottomRight().getY() < buttonTopLeft.getY() || rectButton.getBottomRight().getX() < buttonTopLeft.getX())) {
            result = true;
        }
        return result;
    }

    public boolean isInside(RectButton rectButton) {
        return isInside(rectButton.getTopLeft()) && isInside(rectButton.getBottomRight());
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return buttonTopLeft.isVisibleOnDesktop(desktop) && buttonBottomRight.isVisibleOnDesktop(desktop);
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
        RectButton that = (RectButton) o;
        return buttonActive == that.buttonActive &&
                Objects.equals(buttonTopLeft, that.buttonTopLeft) &&
                Objects.equals(buttonBottomRight, that.buttonBottomRight) &&
                Objects.equals(buttonText, that.buttonText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buttonActive, buttonTopLeft, buttonBottomRight, buttonText);
    }
}
