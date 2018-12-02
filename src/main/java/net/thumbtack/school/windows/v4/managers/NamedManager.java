package net.thumbtack.school.windows.v4.managers;

import net.thumbtack.school.windows.v4.base.Window;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;

public class NamedManager<T extends Window> extends Manager<T> {

    private String name;

    public NamedManager (T window, String name)throws WindowException {
        super(window);
        if (name == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
