package net.thumbtack.school.windows.v1;

import com.sun.prism.impl.shape.MaskData;

import java.util.Objects;

public class RectButton {

    private boolean buttonActive;
    private Point buttonTopLeft;
    private Point buttonBottomRight;
    private int buttonXLeft;
    private int buttonYLeft;
    private int buttonXRight;
    private int buttonYRight;
    private int buttonWidth;
    private int buttonHeight;


    public RectButton(Point topLeft, Point bottomRight, boolean active) {
        buttonTopLeft = topLeft;
        buttonBottomRight = bottomRight;
        buttonXLeft = buttonTopLeft.getX();
        buttonYLeft = buttonTopLeft.getY();
        buttonXRight = buttonBottomRight.getX();
        buttonYRight = buttonBottomRight.getY();
        buttonWidth = buttonXRight - buttonXLeft + 1;
        buttonHeight = buttonYRight - buttonYLeft + 1;
        buttonActive = active;
    }

    public RectButton(int xLeft, int yTop, int width, int height, boolean active) {
        buttonXLeft = xLeft;
        buttonYLeft = yTop;
        buttonWidth = width;
        buttonHeight = height;
        buttonXRight = xLeft + width - 1;
        buttonYRight = yTop + height - 1;
        buttonTopLeft = new Point(buttonXLeft, buttonYLeft);
        buttonBottomRight = new Point(buttonXRight, buttonYRight);
        buttonActive = active;
    }

    public RectButton(Point topLeft, Point bottomRight) {
        buttonTopLeft = topLeft;
        buttonBottomRight = bottomRight;
        buttonXLeft = buttonTopLeft.getX();
        buttonYLeft = buttonTopLeft.getY();
        buttonXRight = buttonBottomRight.getX();
        buttonYRight = buttonBottomRight.getY();
        buttonWidth = buttonXRight - buttonXLeft + 1;
        buttonHeight = buttonYRight - buttonYLeft + 1;
        buttonActive = true;
    }

    public RectButton(int xLeft, int yTop, int width, int height) {
        buttonXLeft = xLeft;
        buttonYLeft = yTop;
        buttonWidth = width;
        buttonHeight = height;
        buttonXRight = xLeft + width - 1;
        buttonYRight = yTop + height - 1;
        buttonTopLeft = new Point(buttonXLeft, buttonYLeft);
        buttonBottomRight = new Point(buttonXRight, buttonYRight);

        buttonActive = true;
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
        buttonXLeft = buttonTopLeft.getX();
        buttonYLeft = buttonTopLeft.getY();
    }

    public void setBottomRight(Point bottomRight) {
        buttonBottomRight = bottomRight;
        buttonXRight = buttonBottomRight.getX();
        buttonYRight = buttonBottomRight.getY();
    }

    public void setActive(boolean active) {
        buttonActive = active;
    }

    public int getWidth() {
        buttonWidth = buttonXRight - buttonXLeft + 1;
        return buttonWidth;
    }

    public int getHeight() {
        buttonHeight = buttonYRight - buttonYLeft + 1;
        return buttonHeight;
    }

    public void moveTo(int x, int y) {
        int dx = x - buttonTopLeft.getX();
        int dy = y - buttonTopLeft.getY();
        this.moveRel(dx, dy);
    }

    public void moveTo(Point point) {
        int dx = point.getX() - buttonTopLeft.getX();
        int dy = point.getY() - buttonTopLeft.getY();
        this.moveRel(dx, dy);
    }

    public void moveRel(int dx, int dy) {
        buttonTopLeft.setX(buttonTopLeft.getX() + dx);
        buttonTopLeft.setY(buttonTopLeft.getY() + dy);
        buttonBottomRight.setX(buttonBottomRight.getX() + dx);
        buttonBottomRight.setY(buttonBottomRight.getY() + dy);
    }

    public void resize(double ratio) {
        buttonWidth = (int) (((buttonWidth * ratio) < 1) ? 1 : (buttonWidth * ratio));
        buttonHeight = (int) (((buttonHeight * ratio) < 1) ? 1 : (buttonHeight * ratio));
        buttonXRight = buttonXLeft + buttonWidth - 1;
        buttonYRight = buttonYLeft + buttonHeight - 1;
        buttonTopLeft = new Point(buttonXLeft, buttonYLeft);
        buttonBottomRight = new Point(buttonXRight, buttonYRight);
    }

    public boolean isInside(int x, int y) {
        return x >= buttonXLeft && x <= buttonXRight && y >= buttonYLeft && y <= buttonYRight;
    }

    public boolean isInside(Point point) {
        int x = point.getX();
        int y = point.getY();
        return x >= buttonXLeft && x <= buttonXRight && y >= buttonYLeft && y <= buttonYRight;
    }

    public boolean isIntersects(RectButton rectButton) {
        boolean result = false;
        Point[][] Vertices = new Point[4][];
        Vertices [0] = new Point[Math.abs(rectButton.getWidth()-1)];
        Vertices [1] = new Point[Math.abs(rectButton.getWidth()-1)];
        Vertices [2] = new Point[Math.abs(rectButton.getHeight()-1)];
        Vertices [3] = new Point[Math.abs(rectButton.getHeight()-1)];
        for (int i = 0; i < Vertices[0].length; i++) {
            Vertices[0][i] = new Point((rectButton.getTopLeft().getX() + i), rectButton.getTopLeft().getY());
            Vertices[1][i] = new Point((rectButton.getBottomRight().getX() - i), rectButton.getBottomRight().getY());
        }
        for (int i = 0; i < Vertices[2].length; i++) {
            Vertices[2][i] = new Point(rectButton.getTopLeft().getX(), rectButton.getTopLeft().getY() + i);
            Vertices[3][i] = new Point(rectButton.getBottomRight().getX() + i, rectButton.getBottomRight().getY() - i);
        }

        for (int i = 0; i < Vertices.length; i++) {
            for (int j = 0; j < Vertices[i].length; j++) {
                if (isInside(Vertices[i][j]) == true) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean isInside(RectButton rectButton) {
        return isInside(rectButton.getTopLeft()) && isInside(rectButton.getBottomRight());
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return buttonTopLeft.isVisibleOnDesktop(desktop) && buttonBottomRight.isVisibleOnDesktop(desktop);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectButton that = (RectButton) o;
        return buttonActive == that.buttonActive &&
                Objects.equals(buttonTopLeft, that.buttonTopLeft) &&
                Objects.equals(buttonBottomRight, that.buttonBottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buttonActive, buttonTopLeft, buttonBottomRight);
    }
}
