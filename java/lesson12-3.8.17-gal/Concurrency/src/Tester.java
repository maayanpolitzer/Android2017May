public class Tester {
    public static void main(String[] args) throws InterruptedException {
        //example one, classic thread inheritance
        FirstThread ft = new FirstThread();
        ft.start();

        //example 2: calling start from constructor
        new AutomaticThread();


        //example 3: using Runnable object
        Thread threadRunner = new Thread(new MyRunner());
        threadRunner.start();


        //example 4:
        RemoteControlThread rct = new RemoteControlThread();
        rct.start();

        Thread.sleep(2000);
        rct.kill();

        //tips & tricks
        //Runnable implementation is preferred over Thread inheritance

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("inline thread operation");
            }
        }).start();


        //Java 8 trick - using lambda expression
        new Thread(() -> {
            System.out.println("hello from lambda thread");
        }).start();

    }
}
