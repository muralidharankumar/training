package fourth;

import java.util.Scanner;
import java.util.Stack;

public class BalancedStringChecker {

    /**
     * isBalanced method to check if the input string is balanced
     * Time Complexity : O(n)
     * Auxiliary Space : O(n)
     *
     * @param input symbols is passed to check it is balance or not
     * @return balanced string, then true or else false
     */
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the input string
        for (char ch : input.toCharArray()) {
            // Push opening braces onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // For closing braces, check if they match the last opened brace
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing brace
                }
                char lastOpened = stack.pop();
                if (!isMatchingPair(lastOpened, ch)) {
                    return false; // Mismatched braces
                }
            }
        }

        // If stack is empty, all braces are balanced
        return stack.isEmpty();
    }

    /**
     * isMatchingPair method to check if braces are matching pairs
     * Time Complexity : O(1)
     * Auxiliary Space : O(1)
     *
     * @param open
     * @param close
     * @return true when both open and close symbols matches
     */
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String to find balance or not: ");
        String inputString = scanner.next();

        System.out.println("Is balanced: " + isBalanced(inputString));
    }
}
