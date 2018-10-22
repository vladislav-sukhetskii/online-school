package net.thumbtack.school.windows.v2;

import java.util.Objects;

public class ComboBox extends ListBox {

    private Integer comboBoxSelectedItem;

    public ComboBox(Point topLeft, Point bottomRight, boolean active, String[] lines, Integer selected){
        super(topLeft,bottomRight,active,lines);
        comboBoxSelectedItem = selected;
    }

    public ComboBox(int xLeft, int yTop, int width, int height, boolean active, String[] lines, Integer selected){
        super(xLeft, yTop, width, height, active, lines);
        comboBoxSelectedItem = selected;
    }

    public ComboBox(Point topLeft, Point bottomRight,  String[] lines, Integer selected){
        this(topLeft,bottomRight,true,lines,selected);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String[] lines, Integer selected){
        this(xLeft,yTop,width,height,true,lines,selected);
    }

    public Integer getSelected(){
        return comboBoxSelectedItem;
    }

    public void setSelected(Integer selected){
        comboBoxSelectedItem = selected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComboBox comboBox = (ComboBox) o;
        return Objects.equals(comboBoxSelectedItem, comboBox.comboBoxSelectedItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), comboBoxSelectedItem);
    }
}
