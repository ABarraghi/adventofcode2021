import java.util.*;
import java.io.*;

public class part1 {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("input.txt"));
            String[] input = reader.nextLine().split(",");
            int evalPointer = 0;
            int minFuel = Integer.MAX_VALUE, minPos = 0;

            while (evalPointer < input.length) {
                int totalFuel = 0;
                int currEval = Integer.parseInt(input[evalPointer]);
                for (int i = 0; i < input.length; i++) {
                    int currPos = Integer.parseInt(input[i]);
                    totalFuel += Math.abs(currEval - currPos);
                }
                if (totalFuel < minFuel) {
                    minFuel = totalFuel;
                    minPos = evalPointer;
                }
                evalPointer++;
            }

            System.out.println("The horizontal position evaluated to use the least fuel is " + input[minPos]
                    + " with a total fuel usage of " + minFuel);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
