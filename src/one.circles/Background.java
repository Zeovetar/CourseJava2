package one.circles;

import java.awt.*;

public class Background {

    public Color getBkColor() {
        return new Color (
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255));
    }

    //public Color OnBkColor(BkColor){Color Col = BkColor; return Col}
}
///