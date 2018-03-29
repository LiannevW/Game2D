import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;
    public int width;
    public int height;
    public String title;

    private boolean running = false;
    private Thread thread;

//    private BufferedImage testImage;
//    private SpriteSheet sheet;

    private BufferStrategy bs;
    private Graphics g;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void intit() {
        display = new Display(title, width, height);
        Assets.init();
    }

    private void update() {
        System.out.println("in update");
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

//      clear screen
        g.drawImage(Assets.grass, 10, 10, null);

//      drawing

//      end of drawing

        bs.show();
        g.dispose();
    }

    public void run() {
        intit();

        while (running) {
            update();
            render();
        }
        stop();
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
