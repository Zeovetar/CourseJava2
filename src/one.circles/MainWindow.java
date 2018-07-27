package one.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 100;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    int counter = 10;
    Background bk = new Background();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        one.circles.GameCanvas gameCanvas = new one.circles.GameCanvas(this);

        add(gameCanvas, BorderLayout.CENTER);
        initGame();
        setVisible(true);
    }

    one.circles.Sprite[] sprites = new one.circles.Sprite[counter];

    private void initGame() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new one.circles.Ball();
        }
    }



    public void onDrawFrame(one.circles.GameCanvas canvas, Graphics g, float deltaTime) {
        canvas.setBackground(bk.getBkColor());
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(one.circles.GameCanvas canvas, float deltaTime) {


        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(one.circles.GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
}

// Background
/*
package one.circles;

import java.awt.*;

public class Background {

    public Color getBkColor() {
        return new Color (
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255));
    }

*/