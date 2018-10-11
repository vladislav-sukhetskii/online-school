package net.thumbtack.school.windows.v2;

import com.sun.istack.internal.NotNull;
import net.thumbtack.school.base.StringOperations;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class ListBox {
    private Point listTopLeft;
    private Point listBottomRight;
    private boolean listActive;
    private String[] listLines;
    private int listWidth;
    private int listHeight;


    public ListBox(Point topLeft, Point bottomRight, boolean active, String[] lines) {
        listTopLeft = topLeft;
        listBottomRight = bottomRight;
        listWidth = listBottomRight.getX() - listTopLeft.getX() + 1;
        listHeight = listBottomRight.getY() - listTopLeft.getY() + 1;
        listActive = active;
        if (lines != null) {
            listLines = new String[lines.length];
            System.arraycopy(lines, 0, listLines, 0, lines.length);
        } else listLines = null;
    }

    public ListBox(int xLeft, int yTop, int width, int height, boolean active, String[] lines) {
        listTopLeft = new Point(xLeft, yTop);
        listBottomRight = new Point(xLeft + width - 1, yTop + height - 1);
        listWidth = width;
        listHeight = height;
        listActive = active;
        if (lines != null) {
            listLines = new String[lines.length];
            System.arraycopy(lines, 0, listLines, 0, lines.length);
        } else listLines = null;
    }

    public ListBox(Point topLeft, Point bottomRight, String[] lines) {
        listTopLeft = topLeft;
        listBottomRight = bottomRight;
        listWidth = listBottomRight.getX() - listTopLeft.getX() + 1;
        listHeight = listBottomRight.getY() - listTopLeft.getY() + 1;
        listActive = true;
        if (lines != null) {
            listLines = new String[lines.length];
            System.arraycopy(lines, 0, listLines, 0, lines.length);
        } else listLines = null;
    }

    public ListBox(int xLeft, int yTop, int width, int height, String[] lines) {
        listTopLeft = new Point(xLeft, yTop);
        listBottomRight = new Point(xLeft + width - 1, yTop + height - 1);
        listWidth = width;
        listHeight = height;
        listActive = true;
        if (lines != null) {
            listLines = new String[lines.length];
            System.arraycopy(lines, 0, listLines, 0, lines.length);
        } else listLines = null;
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
        int deltaX = Math.abs(listTopLeft.getX() - topLeft.getX());
        int deltaY = Math.abs(listTopLeft.getY() - topLeft.getY());
        listHeight = (listTopLeft.getX() < topLeft.getX()) ? listHeight - deltaY : listHeight + deltaY;
        listWidth = (listTopLeft.getX() < topLeft.getX()) ? listWidth - deltaX : listWidth + deltaX;
        listTopLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        int deltaX = Math.abs(listBottomRight.getX() - bottomRight.getX());
        int deltaY = Math.abs(listBottomRight.getY() - bottomRight.getY());
        listHeight = (listBottomRight.getX() > bottomRight.getX()) ? listHeight - deltaY : listHeight + deltaY;
        listWidth = (listBottomRight.getX() > bottomRight.getX()) ? listWidth - deltaX : listWidth + deltaX;
        listBottomRight = bottomRight;
    }

    public void setActive(boolean active) {
        listActive = active;
    }

    public int getWidth() {
        return listWidth;
    }

    public int getHeight() {
        return listHeight;
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
                if (listLines[i] == line) {
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
            int lastPos = listLines.length - 1;
            if (listLines != null) {
                for (int i = 0; i < (listLines.length / 2); i++) {
                    temp = listLines[i];
                    listLines[i] = listLines[lastPos - i];
                    listLines[lastPos - i] = temp;
                }
            }
        }
    }


    public void reverseLines() {
        if (listLines != null) {
            String[] tempArray = new String[listLines.length];
            System.arraycopy(listLines, 0, tempArray, 0, listLines.length);
            for (int i = 0; i < tempArray.length; i++) {
                listLines[i] = StringOperations.reverse(tempArray[i]);
            }
        }
    }

    public void duplicateLines() {
        if (listLines != null) {
            String[] tempArray = new String[listLines.length];
            System.arraycopy(listLines, 0, tempArray, 0, listLines.length);
            listLines = new String[tempArray.length * 2];
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
            String[] tempArray = new String[listLines.length];
            System.arraycopy(listLines, 0, tempArray, 0, listLines.length);
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
                if (StringOperations.isLess(listLines[i + 1], listLines[i]) == false) {
                    result = false;
                    break;
                }

            }
        }
        return result;
    }

    public void moveTo(int x, int y) {
        int dx = x - listTopLeft.getX();
        int dy = y - listTopLeft.getY();
        this.moveRel(dx, dy);
        listTopLeft = new Point(x, y);

    }

    public void moveTo(Point point) {
        int dx = point.getX() - listTopLeft.getX();
        int dy = point.getY() - listTopLeft.getY();
        this.moveRel(dx, dy);
        listTopLeft = point;
    }

    public void moveRel(int dx, int dy) {
        listTopLeft.setX(listTopLeft.getX() + dx);
        listTopLeft.setY(listTopLeft.getY() + dy);
        listBottomRight.setX(listBottomRight.getX() + dx);
        listBottomRight.setY(listBottomRight.getY() + dy);
    }

    public void resize(double ratio) {
        listWidth = (int) (((listWidth * ratio) < 1) ? 1 : (listWidth * ratio));
        listHeight = (int) (((listHeight * ratio) < 1) ? 1 : (listHeight * ratio));
        int listXRight = listTopLeft.getX() + listWidth - 1;
        int listYRight = listTopLeft.getY() + listHeight - 1;
        listBottomRight = new Point(listXRight, listYRight);
    }

    public boolean isInside(int x, int y) {
        return x >= listTopLeft.getX() && x <= listBottomRight.getX() && y >= listTopLeft.getY() && y <= listBottomRight.getY();
    }

    public boolean isInside(Point point) {
        int x = point.getX();
        int y = point.getY();
        return x >= listTopLeft.getX() && x <= listBottomRight.getX() && y >= listTopLeft.getY() && y <= listBottomRight.getY();
    }

    public boolean isIntersects(ListBox listBox) {
        boolean result = false;
        Point[][] Vertices = new Point[4][];
        Vertices[0] = new Point[Math.abs(listBox.getWidth() - 1)];
        Vertices[1] = new Point[Math.abs(listBox.getWidth() - 1)];
        Vertices[2] = new Point[Math.abs(listBox.getHeight() - 1)];
        Vertices[3] = new Point[Math.abs(listBox.getHeight() - 1)];
        for (int i = 0; i < Vertices[0].length; i++) {
            Vertices[0][i] = new Point((listBox.getTopLeft().getX() + i), listBox.getTopLeft().getY());
            Vertices[1][i] = new Point((listBox.getBottomRight().getX() - i), listBox.getBottomRight().getY());
        }
        for (int i = 0; i < Vertices[2].length; i++) {
            Vertices[2][i] = new Point(listBox.getTopLeft().getX(), listBox.getTopLeft().getY() + i);
            Vertices[3][i] = new Point(listBox.getBottomRight().getX() + i, listBox.getBottomRight().getY() - i);
        }

        for (int i = 0; i < Vertices.length; i++) {
            for (int j = 0; j < Vertices[i].length; j++) {
                if (isInside(Vertices[i][j])) {
                    result = true;
                    break;
                }
            }
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
                listWidth == listBox.listWidth &&
                listHeight == listBox.listHeight &&
                Objects.equals(listTopLeft, listBox.listTopLeft) &&
                Objects.equals(listBottomRight, listBox.listBottomRight) &&
                Arrays.equals(listLines, listBox.listLines);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(listTopLeft, listBottomRight, listActive, listWidth, listHeight);
        result = 31 * result + Arrays.hashCode(listLines);
        return result;
    }
}
