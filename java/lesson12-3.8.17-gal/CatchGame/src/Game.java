import java.util.Random;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        new Thread(runner).start();

        Random rnd = new Random();
        int current = runner.getCurrent();
        int guess = current + rnd.nextInt(160) - 80;
        while (current < 763) {
            if (guess == current) {
                runner.kill();

                System.out.println("Won!");
                return;
            }
            Thread.sleep(100);
            current = runner.getCurrent();
            guess = current + rnd.nextInt(160) - 80;
        }


        System.out.println("Lost");

    }
}
