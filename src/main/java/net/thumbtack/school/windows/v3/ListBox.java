package net.thumbtack.school.windows.v3;

import net.thumbtack.school.base.StringOperations;
import net.thumbtack.school.windows.v3.base.RectWindow;

import java.util.Arrays;

public class ListBox extends RectWindow {
    
    private String[] lines;

    public ListBox(Point topLeft, Point bottomRight, boolean active, String[] lines) {
        super(topLeft,bottomRight,active);
        if (lines != null) {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        } else this.lines = null;
    }

    public ListBox(int xLeft, int yTop, int width, int height, boolean active, String[] lines) {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), active, lines);
    }

    public ListBox(Point topLeft, Point bottomRight, String[] lines) {
        this(topLeft, bottomRight, true, lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String[] lines) {
        this(xLeft, yTop, width, height, true, lines);
    }

    public String[] getLines() {
        return lines;
    }

    public void setLines(String[] lines) {
        if (lines != null) {
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        } else this.lines = null;
    }

    public String[] getLinesSlice(int from, int to) {
        int j = 0;
        String[] result = null;
        if (lines != null) {
            int newListLength = (to <= lines.length) ? to - from : lines.length;
            int end = (to < lines.length) ? (to) : lines.length;
            result = new String[newListLength];
            for (int i = from; i < end; i++) {
                result[j] = lines[i];
                j++;
            }
        }
        return result;
    }

    public String getLine(int index) {
        String result = null;
        if (index < lines.length) {
            result = lines[index];
        }
        return result;
    }

    public void setLine(int index, String line) {
        if (index < lines.length) {
            lines[index] = line;
        }
    }

    public Integer findLine(String line) {
        Integer result = null;
        if (line != null && lines != null) {
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].equals(line)) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    public void reverseLineOrder() {
        if (lines != null) {
            String temp;
            for (int i = 0; i < (lines.length / 2); i++) {
                temp = lines[i];
                lines[i] = lines[lines.length - 1 - i];
                lines[lines.length - 1 - i] = temp;
            }
        }
    }

    public void reverseLines() {
        if (lines != null) {
            for (int i = 0; i < lines.length; i++) {
                lines[i] = StringOperations.reverse(lines[i]);
            }
        }
    }

    public void duplicateLines() {
        if (lines != null) {
            String[] tempArray = lines;
            lines= new String[tempArray.length * 2];
            int index = 0;
            for (String element : tempArray) {
                lines[index] = element;
                lines[index + 1] = element;
                index += 2;
            }
        }
    }

    public void removeOddLines() {

        int j = 0;
        if (lines != null && lines.length >= 1) {
            String[] tempArray = lines;
            lines = (lines.length % 2 == 0) ? new String[(lines.length / 2)] : new String[(lines.length / 2) + 1];
            for (int i = 0; i < tempArray.length; i += 2) {
                lines[j] = tempArray[i];
                j++;
            }
        }
    }

    public boolean isSortedDescendant() {
        boolean result = true;
        if (lines != null) {
            for (int i = 0; i < lines.length - 1; i++) {
                if (!StringOperations.isLess(lines[i + 1], lines[i])) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public void moveTo(int x, int y) {
        getBottomRight().setX(getBottomRight().getX() + x - getTopLeft().getX());
        getBottomRight().setY(getBottomRight().getY() + y - getTopLeft().getY());
        getTopLeft().setX(x);
        getTopLeft().setY(y);
    }

    public void moveRel(int dx, int dy) {
        this.moveTo(getTopLeft().getX() + dx, getTopLeft().getY() + dy);
    }

    public void resize(double ratio) {
        getBottomRight().setX(getTopLeft().getX() + (((getWidth() * ratio) < 1) ? 1 : (int) (getWidth() * ratio)) - 1);
        getBottomRight().setY(getTopLeft().getY() + (((getHeight() * ratio) < 1) ? 1 : (int) (getHeight() * ratio)) - 1);
    }

    public boolean isIntersects(ListBox listBox) {
        boolean result = false;
        if (!(listBox.getTopLeft().getY() > getBottomRight().getY() || listBox.getTopLeft().getX() > getBottomRight().getX() || listBox.getBottomRight().getY() < getTopLeft().getY() || listBox.getBottomRight().getX() < getTopLeft().getX())) {
            result = true;
        }
        return result;

    }

    public boolean isInside(ListBox listBox) {
        return isInside(listBox.getTopLeft()) && isInside(listBox.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ListBox listBox = (ListBox) o;
        return Arrays.equals(lines, listBox.lines);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(lines);
        return result;
    }
}
