import java.util.*;
import java.io.*;

public class part2 {

    public static void main(String[] args) {
        // Fields
        int x1, x2, y1, y2;
        int xMax = 0, yMax = 0;
        int start = 0, stop = 0;
        int[][] grid;
        Stack<Integer> x1Stack = new Stack<>();
        Stack<Integer> x2Stack = new Stack<>();
        Stack<Integer> y1Stack = new Stack<>();
        Stack<Integer> y2Stack = new Stack<>();
        int overlap = 0;

        try {

            Scanner reader = new Scanner(new File("input.txt"));

            while (reader.hasNextLine()) {
                String input = reader.nextLine();
                String[] tokens = input.split(" ");
                x1 = Integer.parseInt(tokens[0].split(",")[0]);
                y1 = Integer.parseInt(tokens[0].split(",")[1]);
                x2 = Integer.parseInt(tokens[2].split(",")[0]);
                y2 = Integer.parseInt(tokens[2].split(",")[1]);

                if (x1 >= x2) {
                    if (x1 > xMax)
                        xMax = x1;
                }

                else {
                    if (x2 > xMax)
                        xMax = x2;
                }

                if (y1 >= y2) {
                    if (y1 > yMax)
                        yMax = y1;
                }

                else {
                    if (y2 > yMax)
                        yMax = y2;
                }

                x1Stack.push(x1);
                x2Stack.push(x2);
                y1Stack.push(y1);
                y2Stack.push(y2);

            }

            xMax += 1;
            yMax += 1;

            grid = new int[xMax][yMax];

            while (!x1Stack.isEmpty()) {
                x1 = x1Stack.pop();
                x2 = x2Stack.pop();
                y1 = y1Stack.pop();
                y2 = y2Stack.pop();

                if (x1 == x2) {
                    if (y1 > y2) {
                        start = y2;
                        stop = y1 + 1;
                    } else {
                        start = y1;
                        stop = y2 + 1;
                    }
                    while (start < stop) {
                        grid[x1][start]++;
                        start++;
                    }
                    start = 0;
                    stop = 0;
                } else if (y1 == y2) {
                    if (x1 > x2) {
                        start = x2;
                        stop = x1 + 1;
                    } else {
                        start = x1;
                        stop = x2 + 1;
                    }
                    while (start < stop) {
                        grid[start][y1]++;
                        start++;
                    }
                    start = 0;
                    stop = 0;
                }
                // Lines are ever only Horizontal, Vertical, or Diagonal
                else {
                    start = y1;
                    if (y2 > y1) {
                        if (x2 > x1) {
                            while (start <= y2) {
                                grid[x1][start]++;
                                start++;
                                x1++;
                            }
                        } else {
                            while (start <= y2) {
                                grid[x1][start]++;
                                start++;
                                x1--;
                            }
                        }
                    } else {
                        if (x2 > x1) {
                            while (start >= y2) {
                                grid[x1][start]++;
                                start--;
                                x1++;
                            }
                        } else {
                            while (start >= y2) {
                                grid[x1][start]++;
                                start--;
                                x1--;
                            }
                        }
                    }
                }
            }

            System.out.println(grid[0].length);
            System.out.println(grid.length);

            System.out.println(xMax);
            System.out.println(yMax);

            for (int row = 0; row < yMax; row++) {
                for (int col = 0; col < xMax; col++) {
                    if (grid[col][row] >= 2)
                        overlap++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(overlap);

    }

}
