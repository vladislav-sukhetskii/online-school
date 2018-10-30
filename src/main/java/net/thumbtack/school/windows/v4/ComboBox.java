package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

import java.util.Objects;

public class ComboBox extends ListBox {

    private Integer selected;

    public ComboBox(Point topLeft, Point bottomRight, WindowState windowState, String[] lines, Integer selected) throws WindowException {
        super(topLeft, bottomRight, windowState, lines);
        checkSelected(lines, selected);
        this.selected = selected;
    }

    public ComboBox(Point topLeft, Point bottomRight, String windowState, String[] lines, Integer selected) throws WindowException {
        super(topLeft, bottomRight, windowState, lines);
        checkSelected(lines, selected);
        this.selected = selected;
    }

    public ComboBox(int xLeft, int yTop, int width, int height, WindowState windowState, String[] lines, Integer selected) throws WindowException {
        super(xLeft, yTop, width, height, windowState, lines);
        checkSelected(lines, selected);
        this.selected = selected;
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String windowState, String[] lines, Integer selected) throws WindowException {
        super(xLeft, yTop, width, height, windowState, lines);
        checkSelected(lines, selected);
        this.selected = selected;
    }

    public ComboBox(Point topLeft, Point bottomRight, String[] lines, Integer selected) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE, lines, selected);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String[] lines, Integer selected) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.ACTIVE, lines, selected);
    }

    private void checkSelected(String[] lines, Integer selected) throws WindowException {
        if (lines == null && selected != null)
            throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        if (selected != null && (selected > lines.length || selected < 0))
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) throws WindowException {
        checkSetSelected(selected);
        this.selected = selected;
    }

    private void checkSetSelected(Integer selected) throws WindowException {
        if (selected > getLines().length - 1 || selected < 0) throw new WindowException(WindowErrorCode.WRONG_INDEX);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComboBox comboBox = (ComboBox) o;
        return Objects.equals(selected, comboBox.selected);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), selected);
    }
}
