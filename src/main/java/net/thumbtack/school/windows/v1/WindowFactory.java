package net.thumbtack.school.windows.v1;

public class WindowFactory {
    private static int rectCount = 0;
    private static int roundCount = 0;

    public static RectButton createRectButton(Point leftTop, Point rightBottom, boolean active) {
        RectButton newRectButton = new RectButton(leftTop, rightBottom, active);
        rectCount++;
        return newRectButton;
    }

    public static RoundButton createRoundButton(Point center, int radius, boolean active) {
        RoundButton newRoundButton = new RoundButton(center, radius, active);
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
