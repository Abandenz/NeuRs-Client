// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Alert.java


public class Alert {

    public boolean active;
    public boolean open;
    public int opacity;
    public int extraX;
    public int extraY;
    private String title;
    private String line1;
    private String line2;
    private int titleColor;
    private int color1;
    private int color2;
    private boolean closed;
    private int x;
    private int y;

    public Alert(String s, String s1, String s2) {
        active = false;
        closed = false;
        open = true;
        opacity = 0;
        x = 14;
        y = 250;
        extraX = 0;
        extraY = 40;
        title = s;
        line1 = s1;
        line2 = s2;
        titleColor = 0xff0000;
        color1 = 0xffffff;
        color2 = 0xffffff;
        active = true;
    }

    public Alert(String s, String s1, String s2, int i, int j, int k) {
        active = false;
        closed = false;
        open = true;
        opacity = 0;
        x = 14;
        y = 250;
        extraX = 0;
        extraY = 40;
        title = s;
        line1 = s1;
        line2 = s2;
        titleColor = i;
        color1 = j;
        color2 = k;
        active = true;
    }

    public String getTitle() {
        return title;
    }

    public String getLine(int i) {
        return i != 1 ? line2 : line1;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public int getColor(int i) {
        return i != 1 ? color2 : color1;
    }

    public boolean active() {
        return active;
    }

    public void close() {
        closed = true;
    }

    public boolean opening() {
        return open;
    }

    public int getOpacity() {
        return opacity;
    }

    public boolean isClosed() {
        return closed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
