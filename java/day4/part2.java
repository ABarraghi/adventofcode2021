import java.util.*;
import java.io.*;

public class part2 {

    public static void main(String[] args) {

        try {

            Queue<Integer> drawQueue = new LinkedList<>();
            Stack<int[][]> winningStack = new Stack<int[][]>();
            HashMap<int[][], Integer> boardWinDraws = new HashMap<int[][], Integer>();
            ArrayList<int[][]> bingoBoard = new ArrayList<int[][]>();
            int[][] currBoard = new int[5][5];
            int currDraw = 0;
            int colSum = 0, rowSum = 0, totalSum = 0;
            int winningDraw = 0;
            Scanner reader = new Scanner(new File("input.txt"));

            String[] draws = reader.nextLine().split(",");
            for (int i = 0; i < draws.length; i++) {
                drawQueue.add(Integer.parseInt(draws[i]));
            }

            int inputRowIndex = 0;
            while (reader.hasNextLine()) {
                String currLine = reader.nextLine();
                if (currLine.length() == 0) {
                    if (inputRowIndex == 5) {
                        inputRowIndex = 0;
                        bingoBoard.add(currBoard);
                        currBoard = new int[5][5];
                    }
                    continue;
                } else {
                    if (currLine.charAt(0) == ' ')
                        currLine = currLine.replaceFirst(" ", "");
                    String[] inputRow = currLine.split("\\s+");
                    for (int k = 0; k < 5; k++) {
                        currBoard[inputRowIndex][k] = Integer.parseInt(inputRow[k]);
                    }
                    inputRowIndex++;
                }
            }
            // Add final board
            bingoBoard.add(currBoard);
            currBoard = new int[5][5];

            while (!drawQueue.isEmpty()) {
                currDraw = drawQueue.poll();

                for (int boardIndex = 0; boardIndex < bingoBoard.size() - 1; boardIndex++) {
                    currBoard = bingoBoard.get(boardIndex);

                    // Replace each instance of currently polled bingo draw in each board
                    for (int row = 0; row < 5; row++) {
                        for (int col = 0; col < 5; col++) {
                            if (currBoard[row][col] == currDraw)
                                currBoard[row][col] = -1;
                        }
                    }

                    // Check rows/cols for win - winning row/col will equal -5
                    for (int sumIndex = 0; sumIndex < 5; sumIndex++) {
                        for (int col = 0; col < 5; col++) {
                            rowSum += currBoard[sumIndex][col];
                        }
                        for (int row = 0; row < 5; row++) {
                            colSum += currBoard[row][sumIndex];
                        }
                        if (rowSum == -5 || colSum == -5) {
                            winningStack.push(currBoard);
                            boardWinDraws.put(currBoard, currDraw);
                            bingoBoard.remove(boardIndex);
                            rowSum = 0;
                            colSum = 0;
                            boardIndex--;
                            break;
                        }

                        rowSum = 0;
                        colSum = 0;
                    }
                }

            }

            // Last winning board is at top of stack
            currBoard = winningStack.pop();
            winningDraw = boardWinDraws.get(currBoard);
            // Sum all unmarked entries in currBoard, multiply it by the current draw
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (currBoard[row][col] != -1) {
                        totalSum += currBoard[row][col];
                    }
                }
            }
            totalSum *= winningDraw;

            System.out.println("Final score is: " + totalSum);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}