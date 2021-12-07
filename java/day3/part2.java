import java.io.*;
import java.util.*;

public class part2 {

    public static void main(String[] args) {

        try {
            String lineBits = "";
            ArrayList<String> oxygenArray = new ArrayList<String>(), co2Array = new ArrayList<String>();
            int totalZeroBits = 0, totalOneBits = 0;
            Scanner reader = new Scanner(new File("input.txt"));
            char maxBit = ' ', minBit = ' ';
            int oxygen = 0, co2 = 0, lifeSupport = 0;

            while (reader.hasNextLine()) {
                lineBits = reader.nextLine();

                oxygenArray.add(lineBits);
                co2Array.add(lineBits);
            }

            int pos = 0;
            while (oxygenArray.size() > 1) {

                for (int i = 0; i < oxygenArray.size(); i++) {
                    if (oxygenArray.get(i).charAt(pos) == '1')
                        totalOneBits++;
                    else
                        totalZeroBits++;
                }

                if (totalOneBits >= totalZeroBits)
                    maxBit = '1';
                else
                    maxBit = '0';

                for (int j = oxygenArray.size() - 1; j >= 0; j--) {
                    if (oxygenArray.get(j).charAt(pos) != maxBit)
                        oxygenArray.remove(j);
                }
                pos++;
                totalOneBits = 0;
                totalZeroBits = 0;
            }

            pos = 0;
            totalOneBits = 0;
            totalZeroBits = 0;

            while (co2Array.size() > 1) {

                for (int i = 0; i < co2Array.size(); i++) {
                    if (co2Array.get(i).charAt(pos) == '1')
                        totalOneBits++;
                    else
                        totalZeroBits++;
                }

                if (totalZeroBits <= totalOneBits)
                    minBit = '0';
                else
                    minBit = '1';

                for (int j = co2Array.size() - 1; j >= 0; j--) {
                    if (co2Array.get(j).charAt(pos) != minBit)
                        co2Array.remove(j);
                }
                pos++;
                totalOneBits = 0;
                totalZeroBits = 0;
            }

            reader.close();

            oxygen = convertBitsToDecimal(oxygenArray.get(0));
            co2 = convertBitsToDecimal(co2Array.get(0));
            lifeSupport = oxygen * co2;

            System.out.println("Life Support is: " + lifeSupport);

        } catch (Exception e) {
            e.printStackTrace();
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