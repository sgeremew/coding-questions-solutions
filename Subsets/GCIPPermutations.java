import java.util.*;
public class Main {
    /*

    bad,  bda,  abd,  adb,  dab,  dba -- 6 permutations

    probably want to convert String to charArray to make swaps easier


    b  a  d
    {}
    0
    ===
    b  a  d
    {}
    1
    ===
    b  a  d
    {}
    2
    ===
    {'bad'}


    */

    public static ArrayList<String> permuteWord(String word) {
        ArrayList<String> permutations = new ArrayList<>();
        backtrack(permutations, word, 0);
        return permutations;
    }

    /** perform swaps recursively to obtain every permuations */
    public static void backtrack(List<String> permutations, String word, int index) {
        // if index is at the last character, add this permutation to the list
        if (index == word.length() - 1) {
            permutations.add(word);
            return;
        } else {
            //
            for(int j = index; j < word.length(); j++) {
                char[] swapped = swap(word, index, j);
                backtrack(permutations, String.valueOf(swapped), index + 1);
            }
        }
    }

    /** swap chars at position i and j */
    public static char[] swap(String word, int i, int j) {
        char[] charArray = word.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return charArray;
    }
}