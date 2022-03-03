import java.io.*;
import java.util.*;

public class part2 {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("input.txt"));
            int totalCount = 0;
            HashMap<String, String> wireSegments = new HashMap<String, String>();
            while (reader.hasNextLine()) {
                String entryVal = "";
                String input = reader.nextLine();
                String one, two, three, four, five, six, seven, eight, nine;
                List<String> inputVals = Arrays.asList(input.substring(0, input.indexOf("|") - 1).split(" "));
                String[] outputVals = input.substring(input.indexOf("|") + 2).split(" ");
                for (int j = 0; j < inputVals.size(); j++) {
                    System.out.println(inputVals.get(j));
                }

                for (int i = 0; i < outputVals.length; i++) {
                    switch (outputVals[i].length()) {
                        case 2:
                            entryVal += "1";
                            break;
                        case 4:
                            entryVal += "4";
                            break;
                        case 3:
                            entryVal += "7";
                            break;
                        case 7:
                            entryVal += "8";
                            break;
                        case 5:
                            if (outputVals[i].contains("e"))
                                entryVal += "5";
                            else if (outputVals[i].contains("g"))
                                entryVal += "2";
                            else
                                entryVal += "3";
                            break;
                        case 6:
                            if (outputVals[i].contains("f") && outputVals[i].contains("a"))
                                entryVal += "9";
                            else if (outputVals[i].contains("f") && outputVals[i].contains("g"))
                                entryVal += "6";
                            else
                                entryVal += "0";
                            break;
                        default:
                            break;
                    }
                    totalCount += Integer.parseInt(entryVal);
                }
            }
            System.out.println("The sum of all output values are: " + totalCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}