package net.thumbtack.school.windows.v4;

import net.thumbtack.school.base.StringOperations;
import net.thumbtack.school.windows.v4.base.RectWindow;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

import java.util.Arrays;

public class ListBox extends RectWindow {

    private String[] lines;

    public ListBox(Point topLeft, Point bottomRight, WindowState windowState, String[] lines) throws WindowException {
        super(topLeft, bottomRight, windowState);
        if (lines != null) {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        } else this.lines = null;
    }

    public ListBox(Point topLeft, Point bottomRight, String windowState, String[] lines) throws WindowException {
        super(topLeft, bottomRight, windowState);
        if (lines != null) {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        } else this.lines = null;
    }

    public ListBox(int xLeft, int yTop, int width, int height, WindowState windowState, String[] lines) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), windowState, lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String windowState, String[] lines) throws WindowException {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1), windowState, lines);
    }

    public ListBox(Point topLeft, Point bottomRight, String[] lines) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE, lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String[] lines) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.ACTIVE, lines);
    }

    public String[] getLines() {
        return lines;
    }

    public void setLines(String[] lines) throws WindowException {
        if (lines != null) {
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        } else this.lines = null;
    }

    public String[] getLinesSlice(int from, int to) throws WindowException {
        if (lines == null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        if (from < 0 || to > lines.length || from > to - 1) throw new WindowException(WindowErrorCode.WRONG_INDEX);
        int j = 0;
        String[] result = new String[to - from];
        for (int i = from; i < to; i++) {
            result[j] = lines[i];
            j++;
        }
        return result;
    }

    public String getLine(int index) throws WindowException {
        checkIndex(index);
        return lines[index];
    }

    public void setLine(int index, String line) throws WindowException {
        checkIndex(index);
        lines[index] = line;
    }

    private void checkIndex(int index) throws WindowException {
        if (lines == null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        if (index > lines.length - 1 || index < 0) throw new WindowException(WindowErrorCode.WRONG_INDEX);
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
            lines = new String[tempArray.length * 2];
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
