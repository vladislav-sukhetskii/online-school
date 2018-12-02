package net.thumbtack.school.windows.v4.managers;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.base.Window;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;

public class PairManager<T extends Window, Y extends Window> {

    private T firstWindow;
    private Y secondWindow;

    public PairManager(T firstWindow, Y secondWindow) throws WindowException {
        if (firstWindow == null || secondWindow == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        this.firstWindow = firstWindow;
        this.secondWindow = secondWindow;
    }


    public T getFirstWindow() {
        return firstWindow;
    }

    public void setFirstWindow(T firstWindow) {
        this.firstWindow = firstWindow;
    }

    public Y getSecondWindow() {
        return secondWindow;
    }

    public void setSecondWindow(Y secondWindow) {
        this.secondWindow = secondWindow;
    }

    public boolean allWindowsFullyVisibleOnDesktop(PairManager pairManager, Desktop desktop) throws WindowException {
        return (firstWindow.isFullyVisibleOnDesktop(desktop) && secondWindow.isFullyVisibleOnDesktop(desktop) && pairManager.getFirstWindow().isFullyVisibleOnDesktop(desktop) && pairManager.getSecondWindow().isFullyVisibleOnDesktop(desktop));
    }

    public static boolean allWindowsFullyVisibleOnDesktop(PairManager pairManager1, PairManager pairManager2, Desktop desktop) {
        return (pairManager1.getFirstWindow().isFullyVisibleOnDesktop(desktop) && pairManager2.getSecondWindow().isFullyVisibleOnDesktop(desktop));
    }
}
