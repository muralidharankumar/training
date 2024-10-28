package five;

import java.util.*;

public class VowelCombinationsUtil {

    /**
     * isVowel validates whether it is vowel character or not
     * Time Complexity : O(1)
     * Auxiliary Space : O(1)
     *
     * @param currentCharacter passed as input
     * @return if it has vowel, it returns true
     */

    private static boolean isVowel(char currentCharacter) {
        return "AEIOUaeiou".indexOf(currentCharacter) != -1;
    }

    /**
     * this method to generate permutations and check for vowel conditions
     * Time Complexity : O(n)
     * Auxiliary Space : O(n)
     *
     * @param inputString passed as input, which will changed dynamically
     * @param prefix      first character
     * @param result      it has final list of combinations of vowels
     */
    private static void findCombinations(String inputString, String prefix, Set<String> result) {
        if (prefix.length() == inputString.length()) {
            if (isVowel(prefix.charAt(0)) && isVowel(prefix.charAt(prefix.length() - 1))) {
                result.add(prefix); // Add valid combination to result set
            }
            return;
        }

        for (int i = 0; i < inputString.length(); i++) {
            if (!prefix.contains(String.valueOf(inputString.charAt(i)))) {
                findCombinations(inputString, prefix + inputString.charAt(i), result);
            }
        }
    }

    public static List<String> getVowelCombinations(String str) {
        Set<String> result = new HashSet<>();
        findCombinations(str, "", result);
        return new ArrayList<>(result); // Return as a list
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String to find Vowel Combinations: ");
        String inputString = scanner.next();
        List<String> combinations = getVowelCombinations(inputString);
        if (combinations.isEmpty()) {
            System.out.println("There are no Vowel Combinations");
        } else {
            System.out.println("Combinations of '" + inputString + "' that start and end with a vowel:");
            combinations.forEach(System.out::println);
        }
    }
}
