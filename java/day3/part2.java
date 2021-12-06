package day3;

import java.io.*;
import java.util.*;

public class part2 {

    public static void main(String[] args) {

        try {
            String lineBits = "";
            ArrayList<String> oxygenArray = new ArrayList<String>(), co2Array = new ArrayList<String>();
            int[] totalZeroBits = new int[12], totalOneBits = new int[12];
            Scanner reader = new Scanner(new File("input.txt"));
            char maxBit = ' ', minBit = ' ';
            int pos = 0;
            int oxygen = 0, co2 = 0, lifeSupport = 0;

            while (reader.hasNextLine()) {
                lineBits = reader.nextLine();

                for (int i = 0; i < lineBits.length(); i++) {
                    if (lineBits.charAt(i) == '1')
                        totalOneBits[i]++;

                    else
                        totalZeroBits[i]++;
                }

                oxygenArray.add(lineBits);
                co2Array.add(lineBits);
            }

            while (oxygenArray.size() > 1) {
                if (totalOneBits[pos] >= totalZeroBits[pos])
                    maxBit = '1';
                else
                    maxBit = '0';
                for (int j = oxygenArray.size() - 1; j >= 0; j--) {
                    if (oxygenArray.get(j).charAt(pos) != maxBit)
                        oxygenArray.remove(j);
                }
                pos++;
            }

            pos = 0;
            while (co2Array.size() > 1) {
                if (totalZeroBits[pos] <= totalOneBits[pos])
                    minBit = '0';
                else
                    minBit = '1';
                for (int j = co2Array.size() - 1; j >= 0; j--) {
                    if (co2Array.get(j).charAt(pos) != minBit)
                        co2Array.remove(j);
                }
                pos++;
            }

            reader.close();

            System.out.println(oxygenArray);
            System.out.println(co2Array);

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