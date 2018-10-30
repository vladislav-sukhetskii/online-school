package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

import java.util.Objects;

public class RadioButton extends RoundButton {

    private boolean checked;

    public RadioButton(Point center, int radius, WindowState windowState, String text, boolean checked) throws WindowException {
        super(center, radius, windowState, text);
        this.checked = checked;
    }

    public RadioButton(Point center, int radius, String windowState, String text, boolean checked) throws WindowException {
        super(center, radius, windowState, text);
        this.checked = checked;
    }

    public RadioButton(int xCenter, int yCenter, int radius, WindowState windowState, String text, boolean checked) throws WindowException {
        this(new Point(xCenter, yCenter), radius, windowState, text, checked);
    }

    public RadioButton(int xCenter, int yCenter, int radius, String windowState, String text, boolean checked) throws WindowException {
        this(new Point(xCenter, yCenter), radius, windowState, text, checked);
    }

    public RadioButton(Point center, int radius, String text, boolean checked) throws WindowException {
        this(center, radius, WindowState.ACTIVE, text, checked);
    }

    public RadioButton(int xCenter, int yCenter, int radius, String text, boolean checked) throws WindowException {
        this(xCenter, yCenter, radius, WindowState.ACTIVE, text, checked);
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RadioButton that = (RadioButton) o;
        return checked == that.checked;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), checked);
    }
}
