public class RemoteControlThread extends Thread {
    private boolean isAlive;

    @Override
    public synchronized void start() {
        isAlive = true;
        super.start();
    }

    @Override
    public void run() {
        super.run();

        try {
            while(isAlive) {
                System.out.println("rem crtl thread is working forever");
                sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void kill() {
        isAlive = false;
        System.out.println("Thread died");
    }
}
