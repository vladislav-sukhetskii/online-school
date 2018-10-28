package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowState;

public class WindowFactory {
    private static int rectCount = 0;
    private static int roundCount = 0;

    public static RectButton createRectButton(Point leftTop, Point rightBottom, WindowState windowState, String text) {
        RectButton newRectButton = new RectButton(leftTop, rightBottom, windowState, text);
        rectCount++;
        return newRectButton;
    }

    public static RectButton createRectButton(Point leftTop, Point rightBottom, String windowState, String text) {
        RectButton newRectButton = new RectButton(leftTop, rightBottom, windowState, text);
        rectCount++;
        return newRectButton;
    }

    public static RoundButton createRoundButton(Point center, int radius, WindowState windowState, String text) {
        RoundButton newRoundButton = new RoundButton(center, radius, windowState, text);
        roundCount++;
        return newRoundButton;
    }

    public static RoundButton createRoundButton(Point center, int radius, String windowState, String text) {
        RoundButton newRoundButton = new RoundButton(center, radius, windowState, text);
        roundCount++;
        return newRoundButton;
    }

    public static int getRectButtonCount() {
        return WindowFactory.rectCount;
    }

    public static int getRoundButtonCount() {
        return WindowFactory.roundCount;
    }

    public static int getWindowCount() {
        return rectCount + roundCount;
    }

    public static void reset() {
        rectCount = 0;
        roundCount = 0;
    }
}
