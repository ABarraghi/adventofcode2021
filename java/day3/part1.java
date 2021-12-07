import java.io.*;
import java.util.*;

public class part1 {

    public static void main(String[] args) {

        try {
            String lineBits = "";
            int[] totalZeroBits = new int[12], totalOneBits = new int[12];
            Scanner reader = new Scanner(new File("input.txt"));
            String gammaBits = "", epsilonBits = "";
            int gamma = 0, epsilon = 0, power = 0;

            while (reader.hasNextLine()) {
                lineBits = reader.nextLine();

                for (int i = 0; i < lineBits.length(); i++) {
                    if (lineBits.charAt(i) == '1')
                        totalOneBits[i]++;
                    else
                        totalZeroBits[i]++;
                }

            }

            for (int j = 0; j < 12; j++) {
                if (totalOneBits[j] > totalZeroBits[j]) {
                    gammaBits += "1";
                    epsilonBits += "0";
                } else {
                    gammaBits += "0";
                    epsilonBits += "1";
                }
            }
            reader.close();

            gamma = convertBitsToDecimal(gammaBits);
            epsilon = convertBitsToDecimal(epsilonBits);
            power = gamma * epsilon;

            System.out.println("Power is: " + power);

        } catch (Exception e) {
        }

    }

    public static int convertBitsToDecimal(String bits) {
        int dec = 0;
        for (int k = 0; k < bits.length(); k++) {
            int currBit = Integer.parseInt(String.valueOf(bits.charAt(k)));
            dec += currBit * Math.pow(2, (11 - k));
        }
        return dec;
    }

}