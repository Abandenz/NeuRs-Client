// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AlertHandler.java


public class AlertHandler {

    public boolean hovered;
    public boolean close;
    public boolean show;
    public boolean remove;
    public Alert alert;
    public client c;

    public AlertHandler(client client1) {
        hovered = false;
        close = false;
        show = false;
        remove = false;
        alert = null;
        c = client1;
    }

    public void close() {
        close = true;
    }

    public void processAlerts() {
        if (alert == null)
            return;
        if (alert.active()) {
            if (close) {
                alert.close();
                close = false;
            }
            if (!alert.isClosed() && alert.getOpacity() < 90 && alert.extraY > 0) {
                alert.opacity += 5;
                if (alert.extraY > 0 && alert.extraY < 0)
                    alert.extraY = 0;
            } else if (alert.isClosed()) {
                alert.extraY += 5;
                if (alert.getOpacity() > 0) {
                    alert.opacity -= 5;
                } else {
                    remove = true;
                    show = false;
                    alert.active = false;
                }
            } else {
                if (alert.getOpacity() < 90)
                    alert.opacity = 90;
                if (show)
                    if (hovered)
                        c.alertBorderH.drawSprite(alert.getX(), alert.getY());
                    else
                        c.alertBorder.drawSprite(alert.getX(), alert.getY());
                c.aTextDrawingArea_1271.drawText(0, alert.getTitle(), alert.getY() + 16, alert.getX() + 243);
                c.aTextDrawingArea_1271.drawText(alert.getTitleColor(), alert.getTitle(), alert.getY() + 15, alert.getX() + 242);
                c.smallText.drawText(0, alert.getLine(1), alert.getY() + 36, alert.getX() + 243);
                c.smallText.drawText(alert.getColor(2), alert.getLine(1), alert.getY() + 35, alert.getX() + 242);
                c.smallText.drawText(0, alert.getLine(2), alert.getY() + 56, alert.getX() + 243);
                c.smallText.drawText(alert.getColor(2), alert.getLine(2), alert.getY() + 55, alert.getX() + 242);
                show = true;
            }
        }
        if (remove) {
            alert = null;
            remove = false;
        }
    }

    public void processMouse(int i, int j) {
        if (alert == null)
            return;
        if (alert.active()) {
            hovered = i >= alert.getX() && i <= alert.getX() + 484 && j >= alert.getY() && j <= alert.getY() + 79;
            if (hovered) {
                c.menuActionName[1] = "Dismiss";
                c.menuActionID[1] = 476;
                c.menuActionRow = 2;
            }
        }
    }
}
