package net.thumbtack.school.windows.v3;

import net.thumbtack.school.windows.v3.base.RoundWindow;

import java.util.Objects;

public class RoundButton extends RoundWindow {

    private String text;

    public RoundButton(Point center, int radius, boolean active, String text) {
        super(center,radius,active);
        this.text = text;
    }

    public RoundButton(int xCenter, int yCenter, int radius, boolean active, String text) {
        this(new Point(xCenter, yCenter), radius, active, text);
    }

    public RoundButton(Point center, int radius, String text) {
        this(center, radius, true, text);
    }

    public RoundButton(int xCenter, int yCenter, int radius, String text) {
        this(xCenter, yCenter, radius, true, text);
    }

    public void moveTo(int x, int y) {
        getCenter().setX(x);
        getCenter().setY(y);
    }

    public void moveRel(int dx, int dy) {
        this.moveTo(getCenter().getX() + dx, getCenter().getY() + dy);
    }

    public void resize(double ratio) {
        setRadius(((getRadius() * ratio) < 1) ? 1 : (int) (getRadius() * ratio));
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoundButton that = (RoundButton) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), text);
    }
}




