package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.RoundWindow;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

import java.util.Objects;

public class RoundButton extends RoundWindow {

    private String text;

    public RoundButton(Point center, int radius, WindowState windowState, String text) throws WindowException {
        super(center, radius, windowState);
        this.text = text;
    }

    public RoundButton(Point center, int radius, String windowState, String text) throws WindowException {
        super(center, radius, windowState);
        this.text = text;
    }

    public RoundButton(int xCenter, int yCenter, int radius, WindowState windowState, String text) throws WindowException {
        this(new Point(xCenter, yCenter), radius, windowState, text);
    }

    public RoundButton(int xCenter, int yCenter, int radius, String windowState, String text) throws WindowException {
        this(new Point(xCenter, yCenter), radius, windowState, text);
    }

    public RoundButton(Point center, int radius, String text) throws WindowException {
        this(center, radius, WindowState.ACTIVE, text);
    }

    public RoundButton(int xCenter, int yCenter, int radius, String text) throws WindowException {
        this(xCenter, yCenter, radius, WindowState.ACTIVE, text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
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




