public class AutomaticThread extends Thread{

    public AutomaticThread() {
        System.out.println("Automatic thread has started");
        this.start(); //call start (which calls run method on another thread)
    }

    @Override
    public void run() {
        super.run();

        System.out.println("started automatically from auto thread");
    }
}
