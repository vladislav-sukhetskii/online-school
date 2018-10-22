package net.thumbtack.school.windows.v1;

import java.util.Objects;

public class RoundButton {

    private Point buttonCenter;
    private int buttonRadius;
    private boolean buttonIsActive;

    public RoundButton(Point center, int radius, boolean active) {
        buttonCenter = center;
        buttonRadius = radius;
        buttonIsActive = active;
    }

    public RoundButton(int xCenter, int yCenter, int radius, boolean active) {
        this(new Point(xCenter,yCenter),radius,active);
    }

    public RoundButton(Point center, int radius) {
        this(center,radius,true);
    }

    public RoundButton(int xCenter, int yCenter, int radius) {
        this(xCenter,yCenter,radius,true);
    }

    public Point getCenter() {
        return buttonCenter;
    }

    public int getRadius() {
        return buttonRadius;
    }

    public boolean isActive() {
        return buttonIsActive;
    }

    public void moveTo(int x, int y) {
        buttonCenter.setX(x);
        buttonCenter.setY(y);
    }

    public void moveTo(Point point) {
        this.moveTo(point.getX(),point.getY());
    }

    public void setCenter(int x, int y) {
        buttonCenter = new Point(x,y);
    }

    public void setRadius(int radius) {
        buttonRadius = radius;
    }

    public void setActive(boolean active) {
        buttonIsActive = active;
    }

    public void moveRel(int dx, int dy) {
        this.moveTo(buttonCenter.getX()+dx,buttonCenter.getY()+dy);
    }

    public void resize(double ratio) {
        buttonRadius = ((buttonRadius * ratio) < 1) ? 1 : (int) (buttonRadius * ratio);
    }

    public boolean isInside(int x, int y) {
        return buttonRadius >= Math.sqrt((Math.pow((Math.abs(buttonCenter.getX() - x)), 2)) + Math.pow((Math.abs(buttonCenter.getY() - y)), 2));
    }

    public boolean isInside(Point point) {
        return buttonRadius >= Math.sqrt((Math.pow((Math.abs(buttonCenter.getX() - point.getX())), 2)) + Math.pow((Math.abs(buttonCenter.getY() - point.getY())), 2));
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        boolean result = true;
        Point[] dots = new Point[4];
        dots[0] = new Point((buttonCenter.getX() - buttonRadius), buttonCenter.getY());
        dots[1] = new Point(buttonCenter.getX(), (buttonCenter.getY() + buttonRadius));
        dots[2] = new Point((buttonCenter.getX() + buttonRadius), buttonCenter.getY());
        dots[3] = new Point(buttonCenter.getX(), (buttonCenter.getY() - buttonRadius));
        for (Point element:dots){
            if(!element.isVisibleOnDesktop(desktop)) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundButton that = (RoundButton) o;
        return buttonRadius == that.buttonRadius &&
                buttonIsActive == that.buttonIsActive &&
                Objects.equals(buttonCenter, that.buttonCenter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buttonCenter, buttonRadius, buttonIsActive);
    }
}




