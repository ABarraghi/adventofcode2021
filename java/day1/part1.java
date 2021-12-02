import java.io.*;
import java.util.*;

public class part1 {

    public static void main(String[] args) {

        try {
            int counter = 0, prevDepth = 0;
            Scanner reader = new Scanner(new File("input.txt"));

            // currDepth - the depth reading at the current line
            // prevDepth - the depth reading from the previous line
            // For each line in the input, if comparison currDepth > prevDepth is true,
            // increment counter
            while (reader.hasNextLine()) {
                int currDepth = Integer.parseInt(reader.nextLine());
                if (currDepth > prevDepth)
                    counter++;
                prevDepth = currDepth;
            }

            reader.close();
            // Exclude first line
            System.out.println("Times depth measurement increases: " + (counter - 1));

        } catch (Exception e) {
        }
    }
}