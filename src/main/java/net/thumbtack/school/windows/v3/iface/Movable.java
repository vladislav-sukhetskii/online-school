package net.thumbtack.school.windows.v3.iface;

import net.thumbtack.school.windows.v3.Point;

public interface Movable {

    void moveTo(int x, int y);

    default void moveTo(Point point) {
            this.moveTo(point.getX(), point.getY());
        }

    void moveRel(int dx, int dy);

}
