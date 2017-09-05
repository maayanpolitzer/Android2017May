import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {
        String content = "hello world, i'm your first file in here\nthis is a new line of text\nlast line for sure";

        FileOutputStream fos = new FileOutputStream("data.txt");
        fos.write(content.getBytes());
        fos.close(); //SUPER important!

        FileInputStream fis = new FileInputStream("data.txt");
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = fis.read()) != -1) {
            sb.append((char) n);
        }
        fis.close();

        byte[] b = new byte[10];
        String s = new String(b);
        sb.append(s);

        System.out.println(sb.toString());

        String[] arr = "10,13,0,9,111,2".split(",");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
        Integer.parseInt("");
    }
}