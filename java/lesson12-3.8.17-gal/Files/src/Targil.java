import org.omg.CORBA.INTERNAL;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Targil {
    public static void main(String[] args) {
        //trick no' 1 try with resource
        try (FileInputStream fis = new FileInputStream("number.txt")) {

            //buffered reader, which can read entire lines
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String rawNumbers = br.readLine();

            String[] splitedNums = rawNumbers.split(",");

            int min, max;
            min = max = Integer.parseInt(splitedNums[0]);

            for (int i = 1; i < splitedNums.length; i++) {
                int current = Integer.parseInt(splitedNums[i]);
                if (max < current) max = current;
                else if (min > current) min = current;
            }

            System.out.println("min=" + min + ", max=" + max);

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


        double a = 5, b = 7;
        double max = (a + b) / 2 + Math.abs(a - b) / 2;
    }
}
