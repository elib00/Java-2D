package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    public final int originalTileSize = 16;
    public final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCols = 16;
    public final int maxScreenRows = 12;
    public final int screenWidth = tileSize * maxScreenCols;
    public final int screenHeight = tileSize * maxScreenRows;

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            // System.out.println("hello world");
            update();
            repaint();
        }
    }

    public void update() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        // paint in the center of the screen
        g2.fillRect(screenWidth / 2 - tileSize / 2, screenHeight / 2 - tileSize / 2, tileSize, tileSize);
        g2.dispose();
    }

}
