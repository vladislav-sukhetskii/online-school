package net.thumbtack.school.windows.v1;

public class WindowFactory {
    static private int rectCount = 0;
    static private int roundCount = 0;

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
        return WindowFactory.rectCount + WindowFactory.roundCount;
    }

    public static void reset() {
        rectCount = 0;
        roundCount = 0;
    }


}
