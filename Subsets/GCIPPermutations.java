import java.util.*;
public class Main{
    /*
         bad
      abd   bda
    adb.  dba

    bad >>curr=0;i=0; swap;
        bad >>curr=1;i=1; swap;
            bad >>curr=2;i=2; add word to perms ["bad",] and recurse up
        bad >>cur=1;i=2; swap;
            bda >>curr=2;i=2; add word to perms ["bad","bda"] and recurse up
        loop done, recurse up
    bad >>curr=0;i=1; swap;
        abd >>curr=1;i=1; swap;
            abd >>curr=2;i=2; add word to perms ["bad","bda","abd"] and recurse up
            ...
            ...

    */
    public static ArrayList<String> permuteWord(String word) {
        ArrayList<String> perms = new ArrayList<>();
        backtrack(0, perms, word);
        return perms;
    }

    /** recursion for permutations of given word */
    public static void backtrack(int curr, List<String> perms, String word) {
        if(curr == word.length() - 1) {
            perms.add(word);
            return;
        } else {
            for(int i = curr; i < word.length(); i++) {
                char[] swapped = swap(word, curr, i);
                backtrack(curr + 1, perms, String.valueOf(swapped));
            }
        }
    }

    /** swap characters at positions i and j in given word */ 
    public static char[] swap(String word, int i, int j) {
        char[] charArray = word.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return charArray;
    }
}