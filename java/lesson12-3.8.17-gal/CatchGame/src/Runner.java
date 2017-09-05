public class Runner implements Runnable {
    private volatile int current;
    private boolean isAlive;

    public int getCurrent() {
        return current;
    }

    @Override
    public void run() {
        isAlive = true;
        try {
            for (current = 0; (++current < 763) && isAlive; ) {
                System.out.println("current - " + current);
                Thread.sleep(100);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void kill() {
        isAlive = false;
    }
}
