import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Random;

public class Tester {
    public static void main(String[] args) {

        //unchecked exception - RuntimeException
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int t = numbers[9]; //10

        //int e = numbers[15];// RuntimeException is thrown


        //checked Exceptions
        try (FileOutputStream fos = new FileOutputStream("data.txt")){

            doSomethingDangerous();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOIOIOIO");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Interrupted");
        } finally {
            //clean ups



        }


    }

    public static void doSomethingDangerous() throws FileNotFoundException, InterruptedException, FileAlreadyExistsException {
        int num = new Random().nextInt(3);

        switch (num) {
            case 0:
                throw new FileNotFoundException("hello exception");
            case 1:
                throw new InterruptedException("interrupted");
            default:
                throw new FileAlreadyExistsException("interrupted");
        }
    }
}
