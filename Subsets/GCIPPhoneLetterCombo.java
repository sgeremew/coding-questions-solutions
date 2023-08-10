import java.util.*;

public class Main{
    /*

mapping= {2:abc, 3:def, 4:ghi, 5:jkl, 6:mno, 7:pqrs, 8:tuv, 9:wxyz}

num=234
result= adg adh adi aeg aeh aei afg afh afi bdg bdh ...

abc def ghi

a           i=0
    ad      i=1
        adg i=2 >> add to set of combos; remove g and continue;
        adh i=2 >> add to set of combos; remove h and continue;
        adi i=2 >> add to set of combos; remove i and continue;
    ae
        aeg
        aeh
        aei
...
...

    */

    // phone number mappings
    Map<Character, String> phoneLetters = new HashMap<>();


    public List<String> letterCombinations(String digits){
        //initialize phone number mappings
        phoneLetters.put('2', "abc");
        phoneLetters.put('3', "def");
        phoneLetters.put('4', "ghi");
        phoneLetters.put('5', "jkl");
        phoneLetters.put('6', "mno");
        phoneLetters.put('7', "pqrs");
        phoneLetters.put('8', "tuv");
        phoneLetters.put('9', "wxyz");

        List<String> combos = new ArrayList<>();
        backtrack(combos, new char[digits.length()], digits, 0);
        return combos;
    }

    public void backtrack(List<String> combos, char[] charArray, String digits, int digitIndex) {
        if(digitIndex == charArray.length) {
            combos.add(String.valueOf(charArray));
            return;
        }

        String letters = phoneLetters.get(digits.charAt(digitIndex));

        // try each letter in letters
        for(int i = 0; i < letters.length(); i++) {
            charArray[digitIndex] = letters.charAt(i);
            backtrack(combos, charArray, digits, digitIndex + 1);
            charArray[digitIndex] = '0'; // "empty"
        }
    }
}












