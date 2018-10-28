package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowState;

import java.util.Objects;

public class ComboBox extends ListBox {

    private Integer selected;

    public ComboBox(Point topLeft, Point bottomRight, WindowState windowState, String[] lines, Integer selected) {
        super(topLeft, bottomRight, windowState, lines);
        this.selected = selected;
    }

    public ComboBox(Point topLeft, Point bottomRight, String windowState, String[] lines, Integer selected) {
        super(topLeft, bottomRight, windowState, lines);
        this.selected = selected;
    }

    public ComboBox(int xLeft, int yTop, int width, int height, WindowState windowState, String[] lines, Integer selected) {
        super(xLeft, yTop, width, height, windowState, lines);
        this.selected = selected;
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String windowState, String[] lines, Integer selected) {
        super(xLeft, yTop, width, height, windowState, lines);
        this.selected = selected;
    }

    public ComboBox(Point topLeft, Point bottomRight, String[] lines, Integer selected) {
        this(topLeft, bottomRight, WindowState.ACTIVE, lines, selected);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String[] lines, Integer selected) {
        this(xLeft, yTop, width, height, WindowState.ACTIVE, lines, selected);
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
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
