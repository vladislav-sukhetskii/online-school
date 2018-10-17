package net.thumbtack.school.windows.v2;

import net.thumbtack.school.base.StringOperations;

import java.util.Arrays;
import java.util.Objects;

public class ListBox {

    private Point listTopLeft, listBottomRight;
    private boolean listActive;
    private String[] listLines;

    public ListBox(Point topLeft, Point bottomRight, boolean active, String[] lines) {
        listTopLeft = topLeft;
        listBottomRight = bottomRight;
        listActive = active;
        if (lines != null) {
            listLines = new String[lines.length];
            System.arraycopy(lines, 0, listLines, 0, lines.length);
        } else listLines = null;
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

    public Point getTopLeft() {
        return listTopLeft;
    }

    public Point getBottomRight() {
        return listBottomRight;
    }

    public boolean isActive() {
        return listActive;
    }

    public void setTopLeft(Point topLeft) {
        listTopLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        listBottomRight = bottomRight;
    }

    public void setActive(boolean active) {
        listActive = active;
    }

    public int getWidth() {
        return listBottomRight.getX() - listTopLeft.getX() + 1;
    }

    public int getHeight() {
        return listBottomRight.getY() - listTopLeft.getY() + 1;
    }

    public String[] getLines() {
        return listLines;
    }

    public void setLines(String[] lines) {
        if (lines != null) {
            System.arraycopy(lines, 0, listLines, 0, lines.length);
        } else listLines = null;
    }

    public String[] getLinesSlice(int from, int to) {
        int j = 0;
        String[] result = null;
        if (listLines != null) {
            int newListLength = (to <= listLines.length) ? to - from : listLines.length;
            int end = (to < listLines.length) ? (to) : listLines.length;
            result = new String[newListLength];
            for (int i = from; i < end; i++) {
                result[j] = listLines[i];
                j++;
            }
        }
        return result;
    }

    public String getLine(int index) {
        String result = null;
        if (index < listLines.length) {
            result = listLines[index];
        }
        return result;
    }

    public void setLine(int index, String line) {
        if (index < listLines.length) {
            listLines[index] = line;
        }
    }

    public Integer findLine(String line) {
        Integer result = null;
        if (line != null && listLines != null) {
            for (int i = 0; i < listLines.length; i++) {
                if (listLines[i].equals(line)) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    public void reverseLineOrder() {
        if (listLines != null) {
            String temp;
            for (int i = 0; i < (listLines.length / 2); i++) {
                temp = listLines[i];
                listLines[i] = listLines[listLines.length - 1 - i];
                listLines[listLines.length - 1 - i] = temp;
            }
        }
    }

    public void reverseLines() {
        if (listLines != null) {
            for (int i = 0; i < listLines.length; i++) {
                listLines[i] = StringOperations.reverse(listLines[i]);
            }
        }
    }

    public void duplicateLines() {
        if (listLines != null) {
            String[] tempArray = listLines;
            listLines= new String[tempArray.length * 2];
            int index = 0;
            for (String element : tempArray) {
                listLines[index] = element;
                listLines[index + 1] = element;
                index += 2;
            }
        }
    }

    public void removeOddLines() {

        int j = 0;
        if (listLines != null && listLines.length >= 1) {
            String[] tempArray = listLines;
            listLines = (listLines.length % 2 == 0) ? new String[(listLines.length / 2)] : new String[(listLines.length / 2) + 1];
            for (int i = 0; i < tempArray.length; i += 2) {
                listLines[j] = tempArray[i];
                j++;
            }
        }
    }

    public boolean isSortedDescendant() {
        boolean result = true;
        if (listLines != null) {
            for (int i = 0; i < listLines.length - 1; i++) {
                if (!StringOperations.isLess(listLines[i + 1], listLines[i])) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public void moveTo(int x, int y) {
        listBottomRight.setX(listBottomRight.getX() + x - listTopLeft.getX());
        listBottomRight.setY(listBottomRight.getY() + y - listTopLeft.getY());
        listTopLeft.setX(x);
        listTopLeft.setY(y);
    }

    public void moveTo(Point point) {
        this.moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        this.moveTo(listTopLeft.getX() + dx, listTopLeft.getY() + dy);
    }

    public void resize(double ratio) {
        listBottomRight.setX(listTopLeft.getX() + (((getWidth() * ratio) < 1) ? 1 : (int) (getWidth() * ratio)) - 1);
        listBottomRight.setY(listTopLeft.getY() + (((getHeight() * ratio) < 1) ? 1 : (int) (getHeight() * ratio)) - 1);
    }

    public boolean isInside(int x, int y) {
        return x >= listTopLeft.getX() && x <= listBottomRight.getX() && y >= listTopLeft.getY() && y <= listBottomRight.getY();
    }

    public boolean isInside(Point point) {
        return this.isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(ListBox listBox) {
        boolean result = false;
        if (!(listBox.getTopLeft().getY() > listBottomRight.getY() || listBox.getTopLeft().getX() > listBottomRight.getX() || listBox.getBottomRight().getY() < listTopLeft.getY() || listBox.getBottomRight().getX() < listTopLeft.getX())) {
            result = true;
        }
        return result;

    }

    public boolean isInside(ListBox listBox) {
        return isInside(listBox.getTopLeft()) && isInside(listBox.getBottomRight());
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return listTopLeft.isVisibleOnDesktop(desktop) && listBottomRight.isVisibleOnDesktop(desktop);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListBox listBox = (ListBox) o;
        return listActive == listBox.listActive &&
                Objects.equals(listTopLeft, listBox.listTopLeft) &&
                Objects.equals(listBottomRight, listBox.listBottomRight) &&
                Arrays.equals(listLines, listBox.listLines);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(listTopLeft, listBottomRight, listActive);
        result = 31 * result + Arrays.hashCode(listLines);
        return result;
    }
}
