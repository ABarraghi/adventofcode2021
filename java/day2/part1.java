package day2;

import java.util.*;
import java.io.*;

public class part1 {

    public static void main(String[] args) {

        try {
            int depth = 0, forward = 0;
            Scanner reader = new Scanner(new File("input.txt"));

            while (reader.hasNextLine()) {

                String[] currCommand = reader.nextLine().split(" ");
                switch (currCommand[0]) {
                    case "forward":
                        forward += Integer.parseInt(currCommand[1]);
                        break;
                    case "down":
                        depth += Integer.parseInt(currCommand[1]);
                        break;
                    case "up":
                        depth -= Integer.parseInt(currCommand[1]);
                        break;
                }
            }

            System.out.println("Total depth: " + depth);
            System.out.println("Total forward: " + forward);
            System.out.println("Product: " + (depth * forward));
        } catch (Exception e) {
        }

    }

}