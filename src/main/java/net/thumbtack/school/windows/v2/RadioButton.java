package net.thumbtack.school.windows.v2;

import java.util.Objects;

public class RadioButton extends RoundButton {

    private boolean buttonIsChecked;

    public RadioButton(Point center, int radius, boolean active, String text, boolean checked) {
        super(center, radius, active, text);
        buttonIsChecked = checked;
    }

    public RadioButton(int xCenter, int yCenter, int radius, boolean active, String text, boolean checked) {
        this(new Point(xCenter, yCenter), radius, active, text, checked);
    }

    public RadioButton(Point center, int radius, String text, boolean checked) {
        this(center, radius, true, text, checked);
    }

    public RadioButton(int xCenter, int yCenter, int radius, String text, boolean checked) {
        this(xCenter, yCenter, radius, true, text, checked);
    }

    public boolean isChecked() {
        return buttonIsChecked;
    }

    public void setChecked(boolean checked) {
        buttonIsChecked = checked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RadioButton that = (RadioButton) o;
        return buttonIsChecked == that.buttonIsChecked;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), buttonIsChecked);
    }
}
