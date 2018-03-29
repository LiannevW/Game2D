public class Game implements Runnable {

    private Display display;
    public int width;
    public int height;
    public String title;

    private boolean running = false;
    private Thread thread;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void intit() {
        display = new Display(title, width, height);
    }

    private void update() {

    }

    private void render() {

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
