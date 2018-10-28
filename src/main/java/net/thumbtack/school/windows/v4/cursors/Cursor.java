package net.thumbtack.school.windows.v4.cursors;

import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.base.CursorForm;
import net.thumbtack.school.windows.v4.iface.Movable;

public class Cursor implements Movable {

    int x, y;
    CursorForm cursorForm;

    public Cursor(int x, int y, CursorForm cursorForm) {
        this.x = x;
        this.y = y;
        this.cursorForm = cursorForm;
    }

    public Cursor(Point point, CursorForm cursorForm) {
        this(point.getX(), point.getY(), cursorForm);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CursorForm getCursorForm() {
        return cursorForm;
    }

    public void setCursorForm(CursorForm cursorForm) {
        this.cursorForm = cursorForm;
    }


    @Override
    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.moveTo(x + dx, y + dy);
    }
}
