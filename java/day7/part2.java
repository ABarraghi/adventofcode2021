import java.io.*;
import java.util.*;

public class part2 {
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
                    totalFuel += fuelUsage(currEval, currPos);
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

    public static int fuelUsage(int start, int end) {
        if (start < end) {
            int diff = end - start;
            return diff + fuelUsage(start, end - 1);
        } else if (start > end) {
            int diff = start - end;
            return diff + fuelUsage(start - 1, end);
        } else
            return 0;
    }
}
