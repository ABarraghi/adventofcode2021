import java.util.*;
import java.io.*;

public class part1 {

    public static void main(String[] args) {

        try {
            int totalPoints = 0;
            // Data Structures and Object Declarations
            Scanner reader = new Scanner(new File("input.txt"));
            BalancedChunk bal = new BalancedChunk("<([{", ">)]}");
            HashMap<Character, Integer> pointsMap = new HashMap<>();

            pointsMap.put(')', 3);
            pointsMap.put(']', 57);
            pointsMap.put('}', 1197);
            pointsMap.put('>', 25137);

            while (reader.hasNextLine()) {
                String chunk = reader.nextLine();
                int result = bal.test(chunk);
                switch (result) {
                    case 0:
                    case 2:
                        break;
                    case 1:
                        totalPoints += pointsMap.get(bal.getErroredChar());
                }
            }

            System.out.println("Total Syntax Error points: " + totalPoints);

        } catch (Exception e) {
        }

    }

}

class BalancedChunk {

    protected String openSet;
    protected String closeSet;
    private char erroredChar;
    private int erroredIndex = -1;

    public BalancedChunk(String openSet, String closeSet) {
        this.openSet = openSet;
        this.closeSet = closeSet;
    }

    public int test(String expression)
    // Returns 0 if expression is balanced.
    // Returns 1 if expression has unbalanced symbols.
    // Returns 2 if expression came to end prematurely.
    {
        char currChar = '\0'; // current expression character being studied
        int currCharIndex; // index of current character
        int lastCharIndex; // index of last character in the expression

        int openIndex; // index of current character in openSet
        int closeIndex; // index of current character in closeSet

        boolean stillBalanced = true; // true as long as expression is balanced

        Stack<Integer> stack; // holds unmatched open symbols
        stack = new Stack<Integer>();

        currCharIndex = 0;
        lastCharIndex = expression.length() - 1;

        while (stillBalanced && (currCharIndex <= lastCharIndex))
        // while expression still balanced and not at end of expression
        {
            currChar = expression.charAt(currCharIndex);
            openIndex = openSet.indexOf(currChar);

            if (openIndex != -1) // if the current character is in the openSet
            {
                // Push the index onto the stack.
                stack.push(openIndex);
            } else {
                closeIndex = closeSet.indexOf(currChar);
                if (closeIndex != -1) // if the current character is in the closeSet
                {
                    try // try to pop an index off the stack
                    {
                        openIndex = stack.peek();
                        stack.pop();
                        if (openIndex != closeIndex) // if popped index doesn't match
                            stillBalanced = false; // then expression is not balanced
                    } catch (EmptyStackException e) // if stack was empty
                    {
                        stillBalanced = false; // then expression is not balanced
                    }
                }
            }
            currCharIndex++; // set up processing of next character
        }

        if (!stillBalanced) {
            erroredChar = currChar;
            erroredIndex = currCharIndex;
            return 1; // unbalanced symbols
        } else {
            if (!stack.isEmpty())
                return 2; // premature end of expression
            else
                return 0; // expression is balanced
        }
    }

    // Return the erroneous char at current index
    public char getErroredChar() {
        return erroredChar;
    }

    // Return the erroneous char's index
    public int getErroredIndex() {
        return erroredIndex;
    }

}