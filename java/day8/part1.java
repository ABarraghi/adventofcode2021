import java.io.*;
import java.util.*;

public class part1 {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("input.txt"));
            int oneCount = 0, fourCount = 0, sevenCount = 0, eightCount = 0;
            int totalCount = 0;
            while (reader.hasNextLine()) {
                String input = reader.nextLine();
                String[] outputVals = input.substring(input.indexOf("|") + 2).split(" ");
                for (int i = 0; i < outputVals.length; i++) {
                    switch (outputVals[i].length()) {
                        case 2:
                            oneCount++;
                            break;
                        case 4:
                            fourCount++;
                            break;
                        case 3:
                            sevenCount++;
                            break;
                        case 7:
                            eightCount++;
                            break;
                        default:
                            break;
                    }
                }
            }
            totalCount = oneCount + fourCount + sevenCount + eightCount;
            System.out.println("The total instances of digits 1,4,7,and 8 are: " + totalCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}