import java.io.*;
import java.util.*;

public class part2 {

    public static void main(String[] args) {

        try {
            // read 4 depth values at a time
            // sum1 is taken from a,b,c
            // sum2 is taken from b,c,d
            int a = 0, b = 0, c = 0, d = 0;
            int sum1 = 0, sum2 = 0, counter = 0;
            Scanner reader = new Scanner(new File("input.txt"));

            while (reader.hasNextLine()) {
                // 0 for a b and c means first sliding window
                if (a == 0 && b == 0 && c == 0) {
                    a = Integer.parseInt(reader.nextLine());
                    b = Integer.parseInt(reader.nextLine());
                    c = Integer.parseInt(reader.nextLine());
                }
                // Otherwise, 'slide' each depth value by one
                else {
                    a = b;
                    b = c;
                    c = d;
                }
                d = Integer.parseInt(reader.nextLine());

                sum1 = a + b + c;
                sum2 = b + c + d;

                if (sum2 > sum1)
                    counter++;
            }
            reader.close();
            System.out.println("Times sliding-window depth measurement increases: " + counter);

        } catch (Exception e) {
        }
    }
}
