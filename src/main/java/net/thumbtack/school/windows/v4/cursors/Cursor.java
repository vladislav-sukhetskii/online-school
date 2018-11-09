package net.thumbtack.school.windows.v4.cursors;

import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.iface.Movable;

public class Cursor extends Point implements Movable {

    int x, y;
    CursorForm cursorForm;

    public Cursor(int x, int y, CursorForm cursorForm) {
        super(x,y);
        this.cursorForm = cursorForm;
    }

    public Cursor(Point point, CursorForm cursorForm) {
        this(point.getX(), point.getY(), cursorForm);
    }

    public CursorForm getCursorForm() {
        return cursorForm;
    }

    public void setCursorForm(CursorForm cursorForm) {
        this.cursorForm = cursorForm;
    }

}
